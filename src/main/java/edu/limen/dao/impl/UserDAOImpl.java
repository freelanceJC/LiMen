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

	@SuppressWarnings("unchecked")
	@Override
	public List<User> searchUserByUserName(String userName) {
		// TODO Auto-generated method stub
		if(userName != null)
			return sessionFactory.getCurrentSession().createQuery("select new User(u.id, u.userName) from User as u where u.userName like :userName and u.id in (select ud.id from UserDetail as ud where ud.status in (1,3,5))").setString("userName", "%"+userName+"%").list();
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> searchUserByEmail(String email) {
		// TODO Auto-generated method stub
		if(email != null)
			return sessionFactory.getCurrentSession().createQuery("select new User(u.id, u.userName) from User as u where u.id in (select ud.id from UserDetail as ud where ud.status in (1,3,5) and ud.emailAddress like :email)").setString("email", "%"+email+"%").list();
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> searchUserByGroupName(String groupName, Integer userId){
		if (groupName != null) {
			return sessionFactory.getCurrentSession().createQuery(
					"select new User(u.id, u.userName) from User as u where u.id in " +
							"(select ug.userDetail.id from UserGrouping as ug " +
							"where ug.status in (2,4,8) " +
							"and (ug.group.id in " +
									"(select g1.id from Group as g1 " +
									"where g1.status in (3,5) " +
									"AND g1.name like :groupName)" +
								" OR ug.group.id in " +
									"(select ug3.group.id from UserGrouping as ug3 " +
									"where ug3.userDetail.id = :uid " +
									"and ug3.group.id in " +
										"(select g2.id from Group as g2 " +
										"where g2.status = 1 " +
										"AND g2.name like :groupName" +
										")" +
									")" +
								")" +
							")").setInteger("uid",userId).setString("groupName","%"+groupName+"%").list();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserByGroupIdUserId(Integer groupId, Integer userId){
		if (groupId != null && userId != null) {
			return sessionFactory.getCurrentSession().createQuery(
					"from User as u where u.id in " +
							"(select ug.userDetail.id from UserGrouping as ug where ug.group.id = (select ug1.group.id from UserGrouping ug1 where ug1.status = 8 and ug1.group.id = :groupId and ug1.userID = :uid))").setInteger("uid",userId).setInteger("groupId",groupId).list();
		}
		return null;
		
	}
	
}
