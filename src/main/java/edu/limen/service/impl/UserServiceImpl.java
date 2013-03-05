package edu.limen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.limen.dao.IUserDAO;
import edu.limen.model.pojo.User;
import edu.limen.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDAO userDao;

	@Override
	@Transactional
	public void addUser(User user) {
		userDao.addUser(user);

	}

	@Override
	@Transactional
	public List<User> listUser() {
		return userDao.listUser();
	}
	
	@Override
	@Transactional
	public List<User> searchUserByUserName(String userName) {
		return userDao.searchUserByUserName(userName);
	}
	
	@Override
	@Transactional
	public List<User> searchUserByEmail(String email) {
		return userDao.searchUserByEmail(email);
	}

	@Override
	@Transactional
	public void removeUser(int uid) {
		userDao.removeUser(uid);
	}
	
	@Override
	@Transactional
	public List<User> searchUserByGroupName(String groupName, Integer userId){
		return userDao.searchUserByGroupName(groupName, userId);
	}
	
	@Override
	@Transactional
	public List<User> getUserByGroupIdUserId(Integer groupId, Integer userId){
		return userDao.getUserByGroupIdUserId(groupId, userId);
	}
}
