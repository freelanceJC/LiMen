package edu.limen.model.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_grouping")
public class UserGrouping {

	@Id
	@Column(name="ID", length=10)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USER_ID", nullable=false)
	private UserDetail userDetail;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="GROUPING_ID",nullable=false)
	private Group group;
	
	@Column(name="CREATE_TIME", nullable=false)
	private Timestamp createTime;
	
	@Column(name="STATUS", nullable=false)
	private byte status;

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
