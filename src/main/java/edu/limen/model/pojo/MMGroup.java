package edu.limen.model.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="MM_GROUPING")
public class MMGroup {

	@Id
	@Column(name="ID", length=10)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="EVENT_ID", nullable=false, length=10)
	private int eventID;
	
	@Column(name="GROUP_NUMBER", nullable=false, length=4)
	private int groupNumber;
	
	@Column(name="GROUP_ROW", nullable=false, length=4)
	private int groupRow;
	
	@Column(name="GROUP_COLUMN", nullable=false, length=4)
	private int groupColumn;
	
	@Column(name="GROUP_COLOUR", nullable=false, length=6)
	private int groupColour;
	
	@Column(name="CREATE_TIME", nullable=false)
	private Timestamp createTime;
	
	@Column(name="STATUS", nullable=false)
	private byte status = 1;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public int getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}

	public int getGroupRow() {
		return groupRow;
	}

	public void setGroupRow(int groupRow) {
		this.groupRow = groupRow;
	}

	public int getGroupColumn() {
		return groupColumn;
	}

	public void setGroupColumn(int groupColumn) {
		this.groupColumn = groupColumn;
	}

	public int getGroupColour() {
		return groupColour;
	}

	public void setGroupColour(int groupColour) {
		this.groupColour = groupColour;
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
