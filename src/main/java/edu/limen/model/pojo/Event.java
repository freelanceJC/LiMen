package edu.limen.model.pojo;

import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EVENT")
public class Event {
	
	@Id
	@Column(name="ID", length=10)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="COURSE_ID", length=10)
	private int courseID;
	
	@Column(name="GROUPING_ID", length=10)
	private int groupingID;
	
	@Column(name="USER_ID", nullable=false, length=10)
	private int userID;
	
	@Column(name="NAME", nullable=false, length=50)
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="GRADE", length=10)
	private String grade;
	
	@Column(name="SUBJECT", length=50)
	private String subject;
	
	@Column(name="EVENT_START_TIME")
	private Timestamp startTime;
	
	@Column(name="EVENT_END_TIME")
	private Timestamp endTime;
	
	@Column(name="INTERVAL_IN_BETWEEN_EVENTS", length=10)
	private int interval;
	
	@Column(name="EVENT_VALID_UNTIL")
	private Timestamp validUntil;
	
	@Column(name="CREATE_TIME", nullable=false)
	private Timestamp createTime;
	
	@Column(name="STATUS", nullable=false)
	private byte status;

}
