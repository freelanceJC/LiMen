package edu.limen.model.view;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQuery(name="findGroupByUId", 
query="SELECT user_id, grouping_id, grouping_name, grouping_description FROM user_grouping_view ug WHERE ug.user_id = :user_id", resultClass=UserGrouping.class)
public class UserGrouping implements Serializable{
	
	private static final long serialVersionUID = 8765016103450361311L;
	
	@Column(name="USER_ID")
	private int user_id;

	@Column(name="GROUPING_ID")
	private int grouping_id;
	
	@Column(name="GROUPING_NAME")
	private String grouping_name;
	
	@Column(name="GROUPING_DESCRIPTION")
	private String grouping_description;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getGrouping_id() {
		return grouping_id;
	}

	public void setGrouping_id(int grouping_id) {
		this.grouping_id = grouping_id;
	}

	public String getGrouping_name() {
		return grouping_name;
	}

	public void setGrouping_name(String grouping_name) {
		this.grouping_name = grouping_name;
	}

	public String getGrouping_description() {
		return grouping_description;
	}

	public void setGrouping_description(String grouping_description) {
		this.grouping_description = grouping_description;
	}
}
