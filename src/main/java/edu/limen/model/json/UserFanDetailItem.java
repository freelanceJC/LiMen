package edu.limen.model.json;

import java.io.Serializable;
import java.sql.Date;

public class UserFanDetailItem implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8733255327637447678L;
	private Integer fanUserId;
	private String realName;
	private Date dateOfBirth;
	private String photo;
	private String className;
	private String email;
	
	public Integer getFanUserId() {
		return fanUserId;
	}
	public void setFanUserId(Integer fanUserId) {
		this.fanUserId = fanUserId;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
