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
@Table(name="MATERRIAL_KLICKTEST_QUESTION")
public class QuestionForKlick {

	@Id
	@Column(name="ID", length=10)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="MATERIAL_KLICKTEST_ID", nullable=false, length=10)
	private int klicktestID;
	
	@Column(name="ORDERING", nullable=false, length=4)
	private int ordering;
	
	@Column(name="QUESTION", nullable=false)
	private String question;
	
	@Column(name="SCORE", nullable=false)
	private short score;
	
	@Column(name="CREATE_TIME", nullable=false)
	private Timestamp createTime;
	
	@Column(name="STATUS", nullable=false)
	private byte status;
}
