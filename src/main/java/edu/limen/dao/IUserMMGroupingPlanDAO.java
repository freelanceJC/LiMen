package edu.limen.dao;

import edu.limen.model.pojo.UserMMGroupingPlan;

import java.util.List;

public interface IUserMMGroupingPlanDAO {

	public void addUserMMGroupingPlan(UserMMGroupingPlan usermmgroupingplan);
	
	public List<UserMMGroupingPlan> listUserMMGroupingPlan();
	
	public void removeUserMMGroupingPlan(Integer id);
}
