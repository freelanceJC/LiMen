package edu.limen.dao;

import java.util.List;

import edu.limen.model.pojo.User;

public interface IUserDAO {

	public void addUser(User user);
	
	public List<User> listUser();
	
	public User GetUserById(int id);
	
	public List<User> listUserBySchoolId(Integer schoolid);
	
	public void removeUser(int uid);
	
}
