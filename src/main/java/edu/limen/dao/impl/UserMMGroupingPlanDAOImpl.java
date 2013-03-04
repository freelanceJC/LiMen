package edu.limen.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.limen.dao.IUserMMGroupingPlanDAO;
import edu.limen.model.pojo.UserMMGroupingPlan;

public class UserMMGroupingPlanDAOImpl implements IUserMMGroupingPlanDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addUserMMGroupingPlan(UserMMGroupingPlan usermmgroupingplan) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(usermmgroupingplan);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserMMGroupingPlan> listUserMMGroupingPlan() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from user_mm_grouping_plan where status = 1").list();
	}

	@Override
	public void removeUserMMGroupingPlan(Integer id) {
		// TODO Auto-generated method stub
		UserMMGroupingPlan usermmgroupingpla = (UserMMGroupingPlan)sessionFactory.getCurrentSession().load(UserMMGroupingPlan.class, id);
		
		if(usermmgroupingpla != null){
			if(usermmgroupingpla.getStatus() == 1){
				usermmgroupingpla.setStatus(0);
				sessionFactory.getCurrentSession().update(usermmgroupingpla);
			}
		}
	}

}
