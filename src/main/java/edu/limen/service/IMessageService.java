package edu.limen.service;

import edu.limen.model.pojo.UserMessage;

public interface IMessageService {
	public void addUserMessage(UserMessage userMessage);
	
	public boolean canSendFriendMessage(Integer fromUserId, Integer toUserId);
}
