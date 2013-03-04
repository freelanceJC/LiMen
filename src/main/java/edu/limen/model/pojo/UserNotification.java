package edu.limen.model.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_NOTIFICATION")
public class UserNotification {
	
	@Id
	@Column(name="ID", length=10)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="FROM_USER_ID", nullable=false, length=10)
	private int fromUserID;
	
	@Column(name="TO_USER_ID", nullable=false, length=10)
	private int toUserID;
	
	@Column(name="TITLE", nullable=false)
	private String title;
	
	@Column(name="CONTENT", nullable=false)
	private String content;
	
	@Column(name="CREATE_TIME", nullable=false)
	private Timestamp createTime;
	
	@Column(name="STATUS", nullable=false)
	private byte status;

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
