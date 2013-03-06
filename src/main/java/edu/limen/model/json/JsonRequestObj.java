package edu.limen.model.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class JsonRequestObj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6460473647358567350L;
	private String type;
	private String input;
	private Integer userId;
	private List<String> userIdList = new ArrayList<String>();
	private String status;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<String> getUserIdList() {
		return userIdList;
	}

	public void setUserIdList(List<String> userIdList) {
		this.userIdList = userIdList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
