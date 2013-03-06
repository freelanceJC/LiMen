package edu.limen.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.limen.dao.IUserGroupingDAO;
import edu.limen.model.pojo.UserGrouping;
@Repository
public class UserGroupingDAOImpl implements IUserGroupingDAO {

	@Autowired
	private SessionFactory sessionFactory;


	@SuppressWarnings("unchecked")
	@Override
	public UserGrouping listFriendListGroup(Integer userId) {
		List<UserGrouping> userGrouping = sessionFactory.getCurrentSession().createQuery("from UserGrouping ug " +
				"where ug.userDetail.id = :uid " +
				"and mod(ug.status, 8) = 0" +
				"and ug.group.status = 129 ")
				//"and mod(ug.group.status, 128) = 0 " +
				//"and mod(ug.group.status, 2) = 1")
				.setInteger("uid", userId).list();
		return userGrouping.isEmpty() ? null : userGrouping.get(0);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public UserGrouping getUserGroupingByGroupingIdAndUserId(Integer groupingId, Integer userId) {
		List<UserGrouping> userGroupings = sessionFactory.getCurrentSession()
				.createQuery("from UserGrouping where group.id = :gid and userDetail.id = :uid")
				.setInteger("gid", groupingId).setInteger("uid", userId).list();
		return userGroupings.isEmpty() ? null : userGroupings.get(0);
	}	
	
	@Override
	public void addUserGrouping(UserGrouping userGrouping) {
		sessionFactory.getCurrentSession().save(userGrouping);
	}
	
	@Override
	public void updateUserGrouping(UserGrouping userGrouping) {
		sessionFactory.getCurrentSession().update(userGrouping);
	}
	
	@Override
	public void removeUserGrouping(UserGrouping userGrouping) {
		sessionFactory.getCurrentSession().delete(userGrouping);
	}
}
