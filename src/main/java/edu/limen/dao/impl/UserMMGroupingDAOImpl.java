package edu.limen.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.limen.dao.IUserMMGroupingDAO;
import edu.limen.model.pojo.UserMMGrouping;

public class UserMMGroupingDAOImpl implements IUserMMGroupingDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addUserMMGrouping(UserMMGrouping usermmgrouping) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(usermmgrouping);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserMMGrouping> listUserMMGrouping() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from user_mm_grouping where status = 1").list();
	}

	@Override
	public void removeUserMMGrouping(Integer id) {
		// TODO Auto-generated method stub
		UserMMGrouping usermmgrouping = (UserMMGrouping)sessionFactory.getCurrentSession().load(UserMMGrouping.class, id);
		if(usermmgrouping != null){
			if(usermmgrouping.getStatus() == 1){
				usermmgrouping.setStatus((byte) 0);
				sessionFactory.getCurrentSession().update(usermmgrouping);
			}
		}
	}

}
