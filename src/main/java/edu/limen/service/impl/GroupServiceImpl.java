package edu.limen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.limen.dao.IGroupDAO;
import edu.limen.model.pojo.Group;
import edu.limen.model.pojo.User;
import edu.limen.service.IGroupService;

@Service
public class GroupServiceImpl implements IGroupService{
	
	@Autowired
	private IGroupDAO groupDao;

	@Override
	@Transactional
	public void addGroup(Group group) {
		groupDao.addGroup(group);
	}

	@Override
	@Transactional
	public List<Group> listGroup() {
		return groupDao.listGroup();
	}

	@Override
	@Transactional
	public List<Group> listGroup(String key){
		return groupDao.listGroup(key);
	}

	
	@Override
	@Transactional
	public void removeGroup(int id) {
		groupDao.removeGroup(id);
	}

	@Override
	@Transactional
	public void blockMember(String[] uid){
		groupDao.blockMember(uid);
	}
	
}
