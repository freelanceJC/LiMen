package edu.limen.model.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_message")
public class UserMessage {
	
	@Id
	@Column(name="ID", length=10)
	private int id;
	
	@Column(name="FROM_USER_ID", nullable=false, length=10)
	private int fromUserID;
	
	@Column(name="FROM_GROUPING_ID", length=10)
	private Integer fromGroupingID;
	
	@Column(name="TO_USER_ID", nullable=false, length=10)
	private int toUserID;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="CONTENT", nullable=false)
	private String content;
	
	@Column(name="START_TIME")
	private Timestamp startTime;
	
	@Column(name="END_TIME")
	private Timestamp endTime;
	
	@Column(name="CREATE_TIME")
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

	public void setFromGroupingID(Integer fromGroupingID) {
		this.fromGroupingID = fromGroupingID;
	}

	public int getToUserID() {
		return toUserID;
	}

	public void setToUserID(int toUserID) {
		this.toUserID = toUserID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
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
