package edu.limen.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.limen.dao.ISchoolDAO;
import edu.limen.model.pojo.School;

@Repository
public class SchoolDAOImpl implements ISchoolDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public School findByID(int uid) {
		School school = null;
		List<School> list = sessionFactory.getCurrentSession().createQuery("from School where uid = " + uid).list();
		if(!list.isEmpty()){
			school = list.get(0);
		}
		return school;
	}
	
}
