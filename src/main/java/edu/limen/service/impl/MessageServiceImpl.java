package edu.limen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.limen.dao.IGroupDAO;
import edu.limen.dao.IUserGroupingDAO;
import edu.limen.dao.IUserMessageDAO;
import edu.limen.model.pojo.Group;
import edu.limen.model.pojo.User;
import edu.limen.model.pojo.UserGrouping;
import edu.limen.model.pojo.UserMessage;
import edu.limen.service.IGroupService;
import edu.limen.service.IMessageService;

@Service
public class MessageServiceImpl implements IMessageService{
	
	@Autowired
	private IUserMessageDAO userMessageDao;
	
	@Autowired
	private IUserGroupingDAO userGroupingDao;

	@Override
	@Transactional
	public void addUserMessage(UserMessage userMessage) {
		// TODO Auto-generated method stub
		userMessageDao.addUserMessage(userMessage);
	}
	
	@Override
	@Transactional
	public boolean canSendFriendMessage(Integer fromUserId, Integer toUserId) {
		UserGrouping senderFdListUserGrouping = userGroupingDao.listFriendListGroup(fromUserId);
		if (senderFdListUserGrouping == null) {
			return false;
		}
		Integer senderFdListId = senderFdListUserGrouping.getGroup().getUid();
		byte receiverStatus = userGroupingDao.getUserGroupingByGroupingIdAndUserId(senderFdListId, toUserId).getStatus();
		byte invitedToBeFriendStatus = new Integer(1).byteValue();
		if (receiverStatus == invitedToBeFriendStatus) {
			return true;
		}
		return false;
	}
}
