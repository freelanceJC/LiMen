package edu.limen.model.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_MM_GROUPING")
public class UserMMGrouping {
	
	@Id
	@Column(name="ID", length=10)
	private int id;
	
	@Column(name="USER_ID", nullable=false, length=10)
	private int userID;
	
	@Column(name="MM_GROUPING_ID", nullable=false,length=10)
	private int mmGroupingID;
	
	@Column(name="SEAT_X", nullable=false,length=4)
	private int seatX;
	
	@Column(name="SEAT_Y", nullable=false,length=4)
	private int seatY;
	
	@Column(name="FORCE_SCREEN_DETAIL", length=255)
	private String forceScreenDetail;
	
	@Column(name="PERMISSION")
	private String permission;
	
	@Column(name="CREATE_TIME", nullable=false)
	private Timestamp createTime;
	
	@Column(name="STATUS", nullable=false)
	private byte status = 0;

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

	public String getForceScreenDetail() {
		return forceScreenDetail;
	}

	public void setForceScreenDetail(String forceScreenDetail) {
		this.forceScreenDetail = forceScreenDetail;
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

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}
}
