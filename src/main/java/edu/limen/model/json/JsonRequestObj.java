package edu.limen.model.json;

import java.io.Serializable;

public class JsonRequestObj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6460473647358567350L;
	private String id;
	private String test;
	private String type;
	private String input;
	private Integer userId;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

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
}
