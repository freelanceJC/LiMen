package edu.limen.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import edu.limen.dao.ISchoolUserViewDAO;
import edu.limen.model.view.SchoolUserView;

@Repository
public class SchoolUserViewDAOImpl implements ISchoolUserViewDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public SchoolUserView getSchool(int uid){
		Query query = sessionFactory.getCurrentSession().getNamedQuery("findSchoolByUid").setInteger("uid", uid);
		
//		query.uniqueResult()
		List<SchoolUserView> schoolList = query.list();
		SchoolUserView view=null;
		if(!schoolList.isEmpty()){
			view = schoolList.get(0);
		}
		return view;
	}

}
