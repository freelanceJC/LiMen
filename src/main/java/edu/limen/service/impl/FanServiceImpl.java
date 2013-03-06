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
import edu.limen.dao.IUserFanDAO;
import edu.limen.dao.IUserGroupingDAO;
import edu.limen.model.json.UserFanDetailItem;
import edu.limen.model.json.UserFanListItem;
import edu.limen.model.pojo.Group;
import edu.limen.model.pojo.UserDetail;
import edu.limen.model.pojo.UserFan;
import edu.limen.model.pojo.UserGrouping;
import edu.limen.service.IFanService;

@Service
public class FanServiceImpl implements IFanService {
	
	@Autowired
	private IUserDetailDAO userDetailDao;

	@Autowired
	private IUserFanDAO userFanDao;
	
	@Autowired
	private IUserGroupingDAO userGroupingDao;
	
	@Autowired
	private IGroupDAO groupDao;

	@Override
	@Transactional
	public List<UserFanListItem> listUserFan(Integer userId) {
		List<UserFanListItem> userFanList = new ArrayList<UserFanListItem>();
		UserGrouping userGrouping = userGroupingDao.listFriendListGroup(userId);
			for (UserDetail user : userGrouping.getGroup().getGroupUsers()) {
				if (user.getId() != userId) {
					UserGrouping group = userGroupingDao.getUserGroupingByGroupingIdAndUserId(userGrouping.getGroup().getUid(), user.getId());
					byte fanStatus = group != null ? group.getStatus() : 0;
					userFanList.add(new UserFanListItem(user.getId(), user.getRealNameString(), fanStatus));
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

	@Override
	@Transactional
	public void addFans(Integer userId, List<String> fanUserIds) {
		UserGrouping userGrouping = userGroupingDao.listFriendListGroup(userId);
		if (userGrouping == null) {
			userGrouping = new UserGrouping();
			Group group = new Group();
			group.setName("Friend List");
			group.setStatus(129);
			group.setCreateTime(new Timestamp((new Date()).getTime()));
			groupDao.addGroup(group);
			
			UserDetail userDetail = userDetailDao.listActiveUserDetailByUserId(userId);
			
			userGrouping.setGroup(group);
			userGrouping.setUserDetail(userDetail);
			userGrouping.setCreateTime(new Timestamp((new Date()).getTime()));
			userGrouping.setStatus((byte)8);
			userGroupingDao.addUserGrouping(userGrouping);
		}
		
		for (String newFanId : fanUserIds) {
			
			UserDetail userDetail = userDetailDao.listActiveUserDetailByUserId(Integer.parseInt(newFanId));
			if (userDetail != null) {
				UserGrouping userGroupingMember = new UserGrouping();
				userGroupingMember.setGroup(userGrouping.getGroup());
				userGroupingMember.setUserDetail(userDetail);
				userGroupingMember.setCreateTime(new Timestamp((new Date()).getTime()));
				userGroupingMember.setStatus((byte)0);
				
				UserGrouping fanGroupFriendList = userGroupingDao.listFriendListGroup(Integer.parseInt(newFanId));
				if (fanGroupFriendList == null) {
					// if frield list is null, create an new one for him
					
				}
				//update the fan user grouping status to byte 1 - invited
				
				
			}
			
			
		}
		
//		UserDetail userDetail = userDetailDao.listActiveUserDetailByUserId(userId);
//		if (userDetail != null) {
//			for (String newFanId : fanUserIds) {
//			
//				UserFan userFan = userFanDao.getFan(userId, Integer.parseInt(newFanId));
//				if (userFan == null) {
//					userFan = new UserFan();
//					userFan.setUserId(userId);
//					userFan.setFanUserId(Integer.parseInt(newFanId));
//					userFan.setCreateTime(new Timestamp((new Date()).getTime()));
//					userFan.setStatus((byte)0);
//					userFanDao.addFan(userFan);
//				}
//				
//				UserFan userFanReverse = userFanDao.getFan(Integer.parseInt(newFanId), userId);
//				if (userFanReverse == null) {
//					userFanReverse = new UserFan();
//					userFanReverse.setUserId(Integer.parseInt(newFanId));
//					userFanReverse.setFanUserId(userId);
//					userFanReverse.setCreateTime(new Timestamp((new Date()).getTime()));
//					userFanReverse.setStatus((byte)0);
//					userFanDao.addFan(userFanReverse);
//				}
//			}			
//		}
	}
	
	@Override
	@Transactional
	public void removeFans(Integer userId, List<String> fanUserIds) {
		UserGrouping userGrouping = userGroupingDao.listFriendListGroup(userId);
		if (userGrouping != null) {
			for (String fanId : fanUserIds) {
				UserGrouping group = userGroupingDao.getUserGroupingByGroupingIdAndUserId(
						userGrouping.getGroup().getUid(), Integer.parseInt(fanId));
				if (group != null) {
					userGroupingDao.removeUserGrouping(group);
				}
			}
		}

	}
	
	@Override
	@Transactional
	public void updateFansStatus(Integer userId, List<String> fanUserIds, int status) {
		UserGrouping userGrouping = userGroupingDao.listFriendListGroup(userId);
		for (String fanId : fanUserIds) {
			UserGrouping group = userGroupingDao.getUserGroupingByGroupingIdAndUserId(
					userGrouping.getGroup().getUid(), Integer.parseInt(fanId));
			if (group != null) {
				group.setStatus((byte)status);
				userGroupingDao.updateUserGrouping(group);
			}
		}
	}
	
}
