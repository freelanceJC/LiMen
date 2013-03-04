package edu.limen.dao;

import java.util.List;

import edu.limen.model.json.UserFanListItem;


public interface IUserFanDAO {
	
	
	public List<UserFanListItem> listUserFan(String myUserId);
//public void addGroup(Group group);
//	public List<Group> listGroup();
//	public List<Group> listGroup(String key);
//	public List<Group> listGroupByUser(String uid);
//	public List<Group>	listGroupBySearch(String[] keywords);

}
