package edu.limen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.limen.dao.IGroupDAO;
import edu.limen.dao.IUserMessageDAO;
import edu.limen.model.pojo.Group;
import edu.limen.model.pojo.User;
import edu.limen.model.pojo.UserMessage;
import edu.limen.service.IGroupService;
import edu.limen.service.IMessageService;

@Service
public class MessageServiceImpl implements IMessageService{
	
	@Autowired
	private IUserMessageDAO userMessageDao;

	@Override
	@Transactional
	public void addUserMessage(UserMessage userMessage) {
		// TODO Auto-generated method stub
		userMessageDao.addUserMessage(userMessage);
	}
	
}
