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
	public void removeUser(int uid) {
		userDao.removeUser(uid);
	}

}
