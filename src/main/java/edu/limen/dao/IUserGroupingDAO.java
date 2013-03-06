package edu.limen.dao;

import edu.limen.model.pojo.UserGrouping;


public interface IUserGroupingDAO {

	public UserGrouping listFriendListGroup(Integer userId);

	public UserGrouping getUserGroupingByGroupingIdAndUserId(Integer groupingId, Integer userId);

	public void addUserGrouping(UserGrouping userGrouping);

	public void updateUserGrouping(UserGrouping userGrouping);
	
	public void removeUserGrouping(UserGrouping userGrouping);

}
