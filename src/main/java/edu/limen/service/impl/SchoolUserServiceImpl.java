package edu.limen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.limen.dao.ISchoolUserViewDAO;
import edu.limen.model.view.SchoolUserView;
import edu.limen.service.ISchoolUserService;

@Service
public class SchoolUserServiceImpl implements ISchoolUserService {
	
	@Autowired
	ISchoolUserViewDAO schoolUserDAO;

	@Override
	@Transactional
	public SchoolUserView getSchool(int uid) {
		SchoolUserView view = schoolUserDAO.getSchool(uid);
		return view;
	}

}
