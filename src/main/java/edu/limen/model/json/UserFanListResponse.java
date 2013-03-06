package edu.limen.model.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserFanListResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3301282238429407329L;
	private List<UserFanListItem> userFanList;
	
	public UserFanListResponse () {
		userFanList = new ArrayList<UserFanListItem>();
	}
	
	public List<UserFanListItem> getUserFanList() {
		return userFanList;
	}

	public void setUserFanList(List<UserFanListItem> userFanList) {
		this.userFanList = userFanList;
	}

	public void addUserFanList(UserFanListItem userFanListItem) {
		userFanList.add(userFanListItem);
	}
	
	
}
