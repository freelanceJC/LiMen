package edu.limen.service;

import java.util.List;

import edu.limen.model.pojo.User;

public interface IUserService {

	public void addUser(User user);

	public List<User> listUser();
	
	public void removeUser(int uid);

	public List<User> searchUserByUserName(String userName);

	public List<User> searchUserByEmail(String email);

	public List<User> searchUserByGroupName(String groupName, Integer userId);
	
	public List<User> getUserByGroupIdUserId(Integer groupId, Integer userId);
	
}
