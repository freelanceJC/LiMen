package edu.limen.model.json;

import java.io.Serializable;

public class UserFanListItem implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2410317883066349437L;

	private Integer fanUserId;
	
	private String fanRealName;

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

	@Override
	public String toString() {
		return "UserFanListing [fanUserId=" + fanUserId + ", fanRealName="
				+ fanRealName + "]";
	}
	
}
