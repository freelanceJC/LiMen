package edu.limen.dao;

import edu.limen.model.pojo.UserMessage;

import java.util.List;

public interface IUserMessageDAO {

	public void addUserMessage(UserMessage usermessage);
	
	public List<UserMessage> listUserMessage();
	
	public void removeUserMessage(Integer id);
}
