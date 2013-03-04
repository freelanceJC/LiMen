package edu.limen.model.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name="findSchoolByUid",
		query="SELECT school_id, school_name, school_detail FROM school_user_view where user_id = :uid", 
		resultClass=SchoolUserView.class)
public class SchoolUserView {

	@Id
	@Column(name="SCHOOL_ID")
	private int schoolID;
	
	@Column(name="SCHOOL_NAME")
	private String schoolName;
	
	@Column(name="SCHOOL_DETAIL")
	private String schoolDetail;

	public int getSchoolID() {
		return schoolID;
	}

	public void setSchoolID(int schoolID) {
		this.schoolID = schoolID;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolDetail() {
		return schoolDetail;
	}

	public void setSchoolDetail(String schoolDetail) {
		this.schoolDetail = schoolDetail;
	}
	
}
