package edu.limen.model.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_MM_GROUPING_PLAN")
public class UserMMGroupingPlan {
	
	@Id
	@Column(name="ID", length=10)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="USER_ID", nullable=false, length=10)
	private int userID;
	
	@Column(name="MM_GROUPING_ID", nullable=false, length=10)
	private int mmGroupingID;
	
	@Column(name="NAME", nullable=false, length=100)
	private String name;
	
	@Column(name="SEAT_X", nullable=false, length=4)
	private int seatX;
	
	@Column(name="SEAT_Y", nullable=false, length=4)
	private int seatY;
	
	@Column(name="PERMISSION")
	private String permission;
	
	@Column(name="CREATE_TIME", nullable=false)
	private Timestamp createTime;
	
	@Column(name="STATUS", nullable=false)
	private int status = 0;

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

	public int getMmGroupingID() {
		return mmGroupingID;
	}

	public void setMmGroupingID(int mmGroupingID) {
		this.mmGroupingID = mmGroupingID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeatX() {
		return seatX;
	}

	public void setSeatX(int seatX) {
		this.seatX = seatX;
	}

	public int getSeatY() {
		return seatY;
	}

	public void setSeatY(int seatY) {
		this.seatY = seatY;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
