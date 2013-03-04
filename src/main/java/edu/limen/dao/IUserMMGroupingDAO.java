package edu.limen.dao;

import edu.limen.model.pojo.UserMMGrouping;

import java.util.List;

public interface IUserMMGroupingDAO {

	public void addUserMMGrouping(UserMMGrouping usermmgrouping);
	
	public List<UserMMGrouping> listUserMMGrouping();
	
	public void removeUserMMGrouping(Integer id);
}
