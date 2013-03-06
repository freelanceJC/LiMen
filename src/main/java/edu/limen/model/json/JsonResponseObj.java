package edu.limen.model.json;

import java.io.Serializable;

public class JsonResponseObj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7213016602727691651L;
	private String responseStatus;

	public JsonResponseObj() {
		responseStatus = "false";
	}
	
	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	
}
