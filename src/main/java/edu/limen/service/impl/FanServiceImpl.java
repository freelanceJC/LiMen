package edu.limen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.limen.dao.IUserDetailDAO;
import edu.limen.dao.IUserFanDAO;
import edu.limen.model.json.UserFanListItem;
import edu.limen.model.pojo.UserDetail;
import edu.limen.service.IFanService;

@Service
public class FanServiceImpl implements IFanService {
	
	@Autowired
	private IUserDetailDAO userDetailDao;

	@Autowired
	private IUserFanDAO userFanDao;


	@Override
	@Transactional
	public List<UserDetail> listUserDetail() {
		List<UserDetail> userDetailList = userDetailDao.listUserDetail();
		return userDetailList;
	}

	@Override
	@Transactional
	public List<UserFanListItem> listUserFan(String userId) {
		List<UserFanListItem> userFanList = userFanDao.listUserFan(userId);
		return userFanList;
	}	


}
