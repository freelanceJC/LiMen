package edu.limen.model.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
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
@Table(name="grouping")
public class Group implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6679452654079802899L;

	@Id
	@Column(name="id", length=10)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name", nullable=false, length=50)
	private String name;

	@Column(name="description")
	private String description;
	
	//@Column(name="level")
	//private String level;
	
	//@Column (name="type", nullable=false)
	//private int type;
	
	@Column(name="create_time", nullable=false)
	private Timestamp createTime;
	
	@Column(name="status", nullable=false)
	private int status;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "user_grouping", 
			joinColumns = { @JoinColumn(name = "grouping_id") }, 
			inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	private List<UserDetail> groupUsers;

	public List<UserDetail> getGroupUsers() {
		return groupUsers;
	}

	public void setGroupUsers(List<UserDetail> groupUsers) {
		this.groupUsers = groupUsers;
	}
	
	public Integer getUid() {
		return id;
	}

	public void setId(Integer uid) {
		this.id = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description=description;
	}
	
	//public String getLevel(){
	//	return level;
	//}
	
	/*public void setLevel(String level){
		this.level=level;
	}
	
	public int getType(){
		return type;
	}
	
	public void setType(int type){
		this.type=type;
	}
	*/
	public void setCreateTime(Timestamp createTime){
		this.createTime=createTime;
	}
	
	public Timestamp getCreateTime(){
		return createTime;
	}
	
	public void setStatus(int status){
		this.status=status;
	}
	public int getStatus(){
		return status;
	}
	
	
}
