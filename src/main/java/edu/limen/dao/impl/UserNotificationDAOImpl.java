package edu.limen.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.limen.dao.IUserNotificationDAO;
import edu.limen.model.pojo.UserNotification;

public class UserNotificationDAOImpl implements IUserNotificationDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addUserNotification(UserNotification usernotification) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(usernotification);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserNotification> listUserNotification() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from user_notification where status = 1").list();
	}

	@Override
	public void removeUserNotification(Integer id) {
		// TODO Auto-generated method stub
		UserNotification usernotification = (UserNotification)sessionFactory.getCurrentSession().load(UserNotification.class, id);
		if(usernotification != null){
			if(usernotification.getStatus() == 1){
				usernotification.setStatus((byte) 0);
				sessionFactory.getCurrentSession().update(usernotification);
			}
		}
	}

}
