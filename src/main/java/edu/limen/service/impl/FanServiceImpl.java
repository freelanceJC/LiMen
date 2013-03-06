package edu.limen.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.limen.dao.IGroupDAO;
import edu.limen.dao.IUserDetailDAO;
import edu.limen.dao.IUserGroupingDAO;
import edu.limen.model.json.UserFanDetailItem;
import edu.limen.model.json.UserFanListItem;
import edu.limen.model.pojo.Group;
import edu.limen.model.pojo.UserDetail;
import edu.limen.model.pojo.UserGrouping;
import edu.limen.service.IFanService;

@Service
public class FanServiceImpl implements IFanService {
	
	@Autowired
	private IUserDetailDAO userDetailDao;
	
	@Autowired
	private IUserGroupingDAO userGroupingDao;
	
	@Autowired
	private IGroupDAO groupDao;

	@Override
	@Transactional
	public List<UserFanListItem> listUserFan(Integer userId) {
		List<UserFanListItem> userFanList = new ArrayList<UserFanListItem>();
		UserGrouping userGrouping = userGroupingDao.listFriendListGroup(userId);
		if (userGrouping != null) {
			for (UserDetail user : userGrouping.getGroup().getGroupUsers()) {
				if (user.getId() != userId) {
					UserGrouping group = userGroupingDao.getUserGroupingByGroupingIdAndUserId(userGrouping.getGroup().getUid(), user.getId());
					byte fanStatus = group != null ? group.getStatus() : 0;
					userFanList.add(new UserFanListItem(user.getId(), user.getRealNameString(), fanStatus));
				}
			}	
		}
		return userFanList;
	}	

	@Override
	@Transactional
	public UserFanDetailItem viewUserDetail(Integer userId) {
		UserFanDetailItem userFanDetailItem = new UserFanDetailItem();
		UserDetail userDetail = userDetailDao.listActiveUserDetailByUserId(userId);
		if (userDetail != null) {
			userFanDetailItem.setFanUserId(userDetail.getId());
			userFanDetailItem.setRealName(userDetail.getRealNameString());
			userFanDetailItem.setDateOfBirth(userDetail.getDateOfBirth());
			userFanDetailItem.setPhoto(userDetail.getPhoto());
		} else {
			userFanDetailItem = null;
		}
		return userFanDetailItem;
	}
	
	private UserGrouping createFriendListGroupWithOwnerUserId(UserDetail user) {
		UserGrouping userGrouping = new UserGrouping();
		Group group = new Group();
		group.setName("Friend List");
		group.setStatus(129);
		group.setCreateTime(new Timestamp((new Date()).getTime()));
		groupDao.addGroup(group);
		
		userGrouping.setGroup(group);
		userGrouping.setUserDetail(user);
		userGrouping.setCreateTime(new Timestamp((new Date()).getTime()));
		userGrouping.setStatus((byte)8);
		userGroupingDao.addUserGrouping(userGrouping);
		return userGrouping;
	}
	
	private void addFriendMember(Group group, UserDetail user, byte status) {
		UserGrouping userGrouping = new UserGrouping();
		userGrouping.setGroup(group);
		userGrouping.setUserDetail(user);
		userGrouping.setCreateTime(new Timestamp((new Date()).getTime()));
		userGrouping.setStatus((byte)status);
		userGroupingDao.addUserGrouping(userGrouping);
	}

	@Override
	@Transactional
	public void addFans(Integer userId, List<Integer> fanUserIds) {
		UserGrouping userGrouping = userGroupingDao.listFriendListGroup(userId);
		UserDetail creatorUserDetail = userDetailDao.listActiveUserDetailByUserId(userId);
		if (userGrouping == null) {
			userGrouping = this.createFriendListGroupWithOwnerUserId(creatorUserDetail);
		}
		
		for (Integer newFanId : fanUserIds) {
			
			UserDetail fanUserDetail = userDetailDao.listActiveUserDetailByUserId(newFanId);
			
			if (fanUserDetail != null) {
				// add new fan into owner list
				if (userGroupingDao.getUserGroupingByGroupingIdAndUserId(userGrouping.getGroup().getUid(), newFanId) == null) {
					this.addFriendMember(userGrouping.getGroup(), fanUserDetail, (byte)1);
				}
								
				UserGrouping fanGroupFriendList = userGroupingDao.listFriendListGroup(newFanId);
				if (fanGroupFriendList == null) {
					// if frield list is null, create an new one for him
					fanGroupFriendList = this.createFriendListGroupWithOwnerUserId(fanUserDetail);
				}
				//update the fan user grouping status to byte 1 - invited
				if (userGroupingDao.getUserGroupingByGroupingIdAndUserId(fanGroupFriendList.getGroup().getUid(), userId) == null) {
					this.addFriendMember(fanGroupFriendList.getGroup(), creatorUserDetail, (byte)0);
				}				
			}
			
		}
	}
	
	@Override
	@Transactional
	public void removeFans(Integer userId, List<Integer> fanUserIds) {
		UserGrouping userGrouping = userGroupingDao.listFriendListGroup(userId);
		if (userGrouping != null) {
			for (Integer fanId : fanUserIds) {
				UserGrouping group = userGroupingDao.getUserGroupingByGroupingIdAndUserId(
						userGrouping.getGroup().getUid(), fanId);
				if (group != null) {
					userGroupingDao.removeUserGrouping(group);
				}
			}
		}

	}
	
	@Override
	@Transactional
	public void updateFansStatus(Integer userId, List<Integer> fanUserIds, int status) {
		UserGrouping userGrouping = userGroupingDao.listFriendListGroup(userId);
		for (Integer fanId : fanUserIds) {
			UserGrouping group = userGroupingDao.getUserGroupingByGroupingIdAndUserId(
					userGrouping.getGroup().getUid(), fanId);
			if (group != null) {
				group.setStatus((byte)status);
				userGroupingDao.updateUserGrouping(group);
			}
		}
	}
	
}
