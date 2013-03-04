package edu.limen.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.limen.dao.IUserFanDAO;
import edu.limen.model.json.UserFanListItem;
@Repository
public class UserFanDAOImpl implements IUserFanDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<UserFanListItem> listUserFan(String myUserId) {
		List<UserFanListItem> userFanList = sessionFactory.getCurrentSession().createQuery(
				"select fan.id as fanUserId, fan.realNameString as fanRealName " +
				" from UserDetail ud inner join ud.userFanList fan " +
				" where ud.id = " + myUserId).list();
		return userFanList;
//		return sessionFactory.getCurrentSession().createQuery("from Group").list();
	}
	

}
