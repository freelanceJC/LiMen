package edu.limen.model.pojo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_detail")
public class UserDetail {

	@Id
	@Column(name="ID", length=10)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="REAL_NAME", nullable=false, length=255)
	private String realNameString;
	
	@Column(name="STUDENT_ID", length=20)
	private String studentID;
	
	@Column(name="STUDENT_GRADE", length=3)
	private String studentGrade;
	
	@Column(name="DATE_OF_BIRTH")
	private Date dateOfBirth;
	
	@Column(name="PHOTO", length=255)
	private String photo;
	
	@Column(name="EMAIL_ADDRESS", length=100)
	private String emailAddress;
	
	@Column(name="DEVICE_ID", length=10)
	private int deviceID;
	
	@Column(name="OPENFIRE_ID", length=50)
	private String openfireID;
	
	@Column(name="EXTRA_ID", length=50)
	private String extraID;
	
	@Column(name="CREATE_TIME", nullable=false)
	private Timestamp createTime;
	
	@Column(name="STATUS", nullable=false)
	private byte status = 1;
	
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "user_grouping",
//            joinColumns = { @JoinColumn(name = "user_id") },
//            inverseJoinColumns = @JoinColumn(name = "grouping_id")
//    )
//    private List<Group> userGroup;
	
//	public List<UserDetail> getUserFanList() {
//		return userFanList;
//	}
//
//	public void setUserFanList(List<UserDetail> userFanList) {
//		this.userFanList = userFanList;
//	}
//	
//	public void addUserFan(UserDetail userDetail) {
//		if (this.userFanList == null) {
//			this.userFanList = new ArrayList<UserDetail>();
//		}
//		this.userFanList.add(userDetail);
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
	public String getRealNameString() {
		return realNameString;
	}

	public void setRealNameString(String realNameString) {
		this.realNameString = realNameString;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getStudentGrade() {
		return studentGrade;
	}

	public void setStudentGrade(String studentGrade) {
		this.studentGrade = studentGrade;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(int deviceID) {
		this.deviceID = deviceID;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getOpenfireID() {
		return openfireID;
	}

	public void setOpenfireID(String openfireID) {
		this.openfireID = openfireID;
	}

	public String getExtraID() {
		return extraID;
	}

	public void setExtraID(String extraID) {
		this.extraID = extraID;
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
