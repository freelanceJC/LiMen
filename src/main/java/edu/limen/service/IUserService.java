package edu.limen.service;

import java.util.List;

import edu.limen.model.pojo.User;

public interface IUserService {

	public void addUser(User user);

	public List<User> listUser();

	public void removeUser(int uid);

}
