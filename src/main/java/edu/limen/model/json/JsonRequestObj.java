package edu.limen.model.json;

import java.io.Serializable;

public class JsonRequestObj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6460473647358567350L;
	private String id;
	private String test;

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
	
	
}
