package edu.limen.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.limen.dao.IGroupDAO;
import edu.limen.model.pojo.Event;
import edu.limen.model.pojo.Group;
import edu.limen.model.pojo.User;
import edu.limen.model.pojo.UserDetail;
@Repository
public class GroupDAOImpl implements IGroupDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addGroup(Group group) {
		@SuppressWarnings("unused")
		Integer abc = (Integer) sessionFactory.getCurrentSession().save(group);
		sessionFactory.getCurrentSession().save(group);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Group> listGroup() {
		return sessionFactory.getCurrentSession().createQuery("from Group").list();
	}
	
	@SuppressWarnings("unchecked")
	@Override 
	public List<Group> listGroup(String key){
		String search=" from Group where id='"+key+"'";
		
		return sessionFactory.getCurrentSession().createQuery(search).list();
		
	}

	@Override
	public void removeGroup(int id) {
		Group group = (Group) sessionFactory.getCurrentSession().load(User.class, id);
		if(group != null) 
		{
			sessionFactory.getCurrentSession().delete(group);
		}
	}

	@Override
	public List<Group> listGroupByUser(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Group> listGroupBySearch(String[] keywords) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createGroup(Group group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGroup(int groupId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableGroup(int groupId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewGroupInfo(int groupId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void joinGroup(String[] uid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void blockMember(String[] uid) {
		sessionFactory.getCurrentSession().createQuery("from Group").list();

	}

	@Override
	public void findMember(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createEvent(Event event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leaveGroup(String uid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addResourse() {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserDetail> listUsersByGroupId(Integer groupingId) {
		List<Group> groupList = sessionFactory.getCurrentSession()
				.createQuery("from Group g inner join g.groupUsers gu where g.id = :gid order by gu.realNameString")
				.setInteger("gid", groupingId).list();
		
		return groupList.isEmpty() ? null : groupList.get(0).getGroupUsers();
	}

}
