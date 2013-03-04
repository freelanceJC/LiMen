package edu.limen.service;

import java.util.List;

import edu.limen.model.pojo.Group;
import edu.limen.model.pojo.User;

public interface IGroupService {
	public void addGroup(Group group);

	public List<Group> listGroup();

	public void removeGroup(int id);

	public void blockMember(String[] uid);
	public List<Group> listGroup(String key);
}
