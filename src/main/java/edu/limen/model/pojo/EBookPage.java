package edu.limen.model.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MATERIAL_EBOOK_PAGE")
public class EBookPage {

	@Id
	@Column(name="ID", length=10)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="MATERIAL_EBOOK_ID", nullable=false, length=10)
	private int eBookID;
	
	@Column(name="MATERIAL_EBOOK_PAGE", nullable=false, length=5)
	private int eBOOKPAGE;
	
	@Column(name="CONTENT", nullable=false)
	private String  content;
	
	@Column(name="CREATE_TIME", nullable=false)
	private Timestamp createTime;
	
	@Column(name="STATUS", nullable=false)
	private byte status;
}
