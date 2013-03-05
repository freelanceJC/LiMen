package edu.limen.model.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_grouping")
public class UserGrouping {

	@Id
	@Column(name="ID", length=10)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="USER_ID", nullable=false, length=10)
	private int userID;
	
	@Column(name="GROUPING_ID",nullable=false, length=10)
	private int groupingID;
	
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

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getGroupingID() {
		return groupingID;
	}

	public void setGroupingID(int groupingID) {
		this.groupingID = groupingID;
	}
	
	
}
