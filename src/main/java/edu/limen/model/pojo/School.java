package edu.limen.model.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SCHOOL")
public class School {

	@Id
	@Column(name="ID", nullable=false, updatable=false, length=10)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="NAME", nullable=false, length=200)
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="SERVER_HOSTNAME")
	private String serverHostname;
	
	@Column(name="SERVER_DATABASE")
	private String serverDatabase;
	
	@Column(name="LICENSE_LEVEL")
	private byte licenseLevel;
	
	@Column(name="LICENSE_EXPIRE_TIME")
	private Timestamp licenseExpireTime;
	
	@Column(name="CREATE_TIME")
	private Timestamp createTime;
	
	@Column(name="STATUS")
	private byte status;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getServerHostname() {
		return serverHostname;
	}

	public void setServerHostname(String serverHostname) {
		this.serverHostname = serverHostname;
	}

	public String getServerDatabase() {
		return serverDatabase;
	}

	public void setServerDatabase(String serverDatabase) {
		this.serverDatabase = serverDatabase;
	}

	public byte getLicenseLevel() {
		return licenseLevel;
	}

	public void setLicenseLevel(byte licenseLevel) {
		this.licenseLevel = licenseLevel;
	}

	public Timestamp getLicenseExpireTime() {
		return licenseExpireTime;
	}

	public void setLicenseExpireTime(Timestamp licenseExpireTime) {
		this.licenseExpireTime = licenseExpireTime;
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
