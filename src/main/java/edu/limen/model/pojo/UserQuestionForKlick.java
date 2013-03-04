package edu.limen.model.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_MATERIAL_KLICKTEST_QUESTION")
public class UserQuestionForKlick {
	
	@Id
	@Column(name="ID", length=10)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="USER_MATERIAL_KLICKTEST_ID", nullable=false, length=10)
	private int userKlicktestID;
	
	@Column(name="MATERIAL_KLICKTEST_QUESTION_ID", nullable=false, length=10)
	private int questionID;

	@Column(name="SCORE_GIVEN", nullable=false)
	private byte scoreGiven;
	
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

	public int getUserKlicktestID() {
		return userKlicktestID;
	}

	public void setUserKlicktestID(int userKlicktestID) {
		this.userKlicktestID = userKlicktestID;
	}

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public byte getScoreGiven() {
		return scoreGiven;
	}

	public void setScoreGiven(byte scoreGiven) {
		this.scoreGiven = scoreGiven;
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
