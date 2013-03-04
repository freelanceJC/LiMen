package edu.limen.dao;

import edu.limen.model.pojo.UserDetail;

import java.util.List;

public interface IUserDetailDAO {

	public void addUserDetail(UserDetail userdetail);
	
	public List<UserDetail> listUserDetail();
	
	public void removeUserDetail(Integer id);
}
