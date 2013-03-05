package edu.limen.dao;

import java.util.List;

import edu.limen.model.pojo.Event;
import edu.limen.model.pojo.Group;
import edu.limen.model.pojo.User;


public interface IGroupDAO {
public void addGroup(Group group);
	public List<Group> listGroup();
	public List<Group> listGroup(String key);
	public List<Group> listGroupByUser(String uid);
	public List<Group>	listGroupBySearch(String[] keywords);
	
	public void createGroup(Group group);
	public void deleteGroup(int groupId);
	public void disableGroup(int groupId);
	public void viewGroupInfo(int groupId);
	public void joinGroup(String[] uid);
	public void blockMember(String[] uid);
	public void findMember(String name);
	public void createEvent(Event event);
	public void leaveGroup(String uid);
	public void addResourse();
	public void removeGroup(int id);
}
