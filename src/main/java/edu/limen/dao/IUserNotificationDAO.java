package edu.limen.dao;

import edu.limen.model.pojo.UserNotification;

import java.util.List;

public interface IUserNotificationDAO {

	public void addUserNotification(UserNotification usernotification);
	
	public List<UserNotification> listUserNotification();
	
	public void removeUserNotification(Integer id);
}
