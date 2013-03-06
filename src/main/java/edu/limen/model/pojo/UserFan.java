package edu.limen.model.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_FAN")
public class UserFan implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6167025286073066505L;

	@Id
	@Column(name="USER_ID", nullable=false, length=10)
	private int userId;
	
	@Id
	@Column(name="FAN_USER_ID", nullable=false, length=10)
	private int fanUserId;
	
	@Column(name="CREATE_TIME", nullable=false)
	private Timestamp createTime;
	
	@Column(name="STATUS", nullable=false)
	private byte status = 0;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFanUserId() {
		return fanUserId;
	}

	public void setFanUserId(int fanUserId) {
		this.fanUserId = fanUserId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fanUserId;
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserFan other = (UserFan) obj;
		if (fanUserId != other.fanUserId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
		

}
