package edu.limen.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.limen.dao.IUserDAO;
import edu.limen.model.pojo.User;

@Repository
public class UserDAOImpl implements IUserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addUser(User user) {
		if(user.getUserName() != null){
			if(sessionFactory.getCurrentSession().createQuery("from user where username = '" + user.getUserName() + "'").list().isEmpty())
				sessionFactory.getCurrentSession().save(user);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUser() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}
	
	@Override
	public User GetUserById(int id){
		try{
			 User user = (User)sessionFactory.getCurrentSession().load(User.class, id);
			 return user;
		}
		catch(HibernateException e){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUserBySchoolId(Integer schoolid) {
		// TODO Auto-generated method stub
		if(schoolid != null)
			return sessionFactory.getCurrentSession().createQuery("from User where school_id = " + schoolid.intValue()).list();
		return null;
	}

	@Override
	public void removeUser(int uid) {
		try{
			User user = (User) sessionFactory.getCurrentSession().load(User.class, uid);
			user.setStatus((byte) 0);
			sessionFactory.getCurrentSession().update(user);
		}
		catch(HibernateException e){}
	}

}
