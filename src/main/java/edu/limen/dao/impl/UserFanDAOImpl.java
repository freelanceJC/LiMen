package edu.limen.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.limen.dao.IUserFanDAO;
import edu.limen.model.pojo.UserFan;
@Repository
public class UserFanDAOImpl implements IUserFanDAO {

	@Autowired
	private SessionFactory sessionFactory;

//	@Override
//	public List<UserFanListItem> listUserFan(String myUserId) {
//		List<UserFanListItem> userFanList = (List<UserFanListItem>)sessionFactory.getCurrentSession().createQuery(
//				"select fan.id as fanUserId, fan.realNameString as fanRealName " +
//				" from UserDetail ud inner join ud.userFanList fan " +
//				" where ud.id = " + myUserId).list();
//		return userFanList;
////		return sessionFactory.getCurrentSession().createQuery("from Group").list();
//	}
	
	@SuppressWarnings("unchecked")
	@Override
	public UserFan getFan(Integer userId, Integer fanUserId) {
		List<UserFan> userFanList = sessionFactory.getCurrentSession()
				.createQuery("from UserFan where userId = :uid and fanUserId = :fanUId")
				.setInteger("uid", userId).setInteger("fanUId", fanUserId).list();
		return userFanList.isEmpty() ? null : userFanList.get(0);
	}	
	
	@Override
	public void addFan(UserFan userFan) {
		sessionFactory.getCurrentSession().save(userFan);
	}
	
	@Override
	public void updateFan(UserFan userFan) {
		sessionFactory.getCurrentSession().update(userFan);
	}
	
	@Override
	public void removeFan(UserFan userFan) {
		sessionFactory.getCurrentSession().delete(userFan);
	}

}
