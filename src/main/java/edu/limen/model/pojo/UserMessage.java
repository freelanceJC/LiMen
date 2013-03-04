package edu.limen.model.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_MESSAGE")
public class UserMessage {
	
	@Id
	@Column(name="ID", length=10)
	private int id;
	
	@Column(name="FROM_USER_ID", nullable=false, length=10)
	private int fromUserID;
	
	@Column(name="FROM_GROUPING_ID", length=10)
	private int fromGroupingID;
	
	@Column(name="TO_USER_ID", nullable=false, length=10)
	private int toUserID;
	
	@Column(name="CONTENT", nullable=false)
	private String content;
	
	@Column(name="SCHEDULE_TIME")
	private Timestamp scheduleTime;
	
	@Column(name="CREATE_TIME", nullable=false)
	private Timestamp createTime;
	
	@Column(name="STATUS")
	private byte status = 0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFromUserID() {
		return fromUserID;
	}

	public void setFromUserID(int fromUserID) {
		this.fromUserID = fromUserID;
	}

	public int getFromGroupingID() {
		return fromGroupingID;
	}

	public void setFromGroupingID(int fromGroupingID) {
		this.fromGroupingID = fromGroupingID;
	}

	public int getToUserID() {
		return toUserID;
	}

	public void setToUserID(int toUserID) {
		this.toUserID = toUserID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(Timestamp scheduleTime) {
		this.scheduleTime = scheduleTime;
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
}
