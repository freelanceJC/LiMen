package edu.limen.dao;

import edu.limen.model.pojo.MMGroup;

import java.util.List;

public interface IMMGroupDAO {
	
	public void addMMGroup(MMGroup mmgroup);
	
	public List<MMGroup> listMMGroup();
	
	public void removeMMGroup(Integer id);
}
