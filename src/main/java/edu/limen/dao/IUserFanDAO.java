package edu.limen.dao;

import edu.limen.model.pojo.UserFan;


public interface IUserFanDAO {
	
	
//	public List<UserFanListItem> listUserFan(String myUserId);
	public UserFan getFan(Integer userId, Integer fanUserId);
	public void addFan(UserFan userFan);
	public void updateFan(UserFan userFan);
	public void removeFan(UserFan userFan);

}
