package edu.limen.model.json;

import java.io.Serializable;

public class UserFanListItem implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2410317883066349437L;

	private Integer fanUserId;
	
	private String fanRealName;
	
	private byte fanStatus;

	public UserFanListItem() {
		
	}
	
	public UserFanListItem(Integer fanUserId, String fanRealName, byte fanStatus) {
		super();
		this.fanUserId = fanUserId;
		this.fanRealName = fanRealName;
		this.fanStatus = fanStatus;
	}

	public Integer getFanUserId() {
		return fanUserId;
	}

	public void setFanUserId(Integer fanUserId) {
		this.fanUserId = fanUserId;
	}

	public String getFanRealName() {
		return fanRealName;
	}

	public void setFanRealName(String fanRealName) {
		this.fanRealName = fanRealName;
	}

	public byte getFanStatus() {
		return fanStatus;
	}

	public void setFanStatus(byte fanStatus) {
		this.fanStatus = fanStatus;
	}
	
}
