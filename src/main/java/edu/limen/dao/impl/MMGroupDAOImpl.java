package edu.limen.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.limen.dao.IMMGroupDAO;
import edu.limen.model.pojo.MMGroup;

public class MMGroupDAOImpl implements IMMGroupDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addMMGroup(MMGroup mmgroup) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(mmgroup);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MMGroup> listMMGroup() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from mmgroup where status = 1").list();
	}

	@Override
	public void removeMMGroup(Integer id) {
		// TODO Auto-generated method stub
		MMGroup mmgroup = (MMGroup)sessionFactory.getCurrentSession().load(MMGroup.class, id);
		if(mmgroup != null){
			if(mmgroup.getStatus() == 1){
				mmgroup.setStatus((byte) 0);
				sessionFactory.getCurrentSession().update(mmgroup);
			}
		}
	}

}
