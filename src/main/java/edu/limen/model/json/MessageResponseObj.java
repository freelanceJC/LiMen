package edu.limen.model.json;

import java.io.Serializable;
import java.util.List;

public class MessageResponseObj implements Serializable {

	private static final long serialVersionUID = -8613808597431139767L;

	private String resultCode;
	private String description;
	
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
