package edu.limen.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.limen.dao.IUserMessageDAO;
import edu.limen.model.pojo.UserMessage;

public class UserMessageDAOImpl implements IUserMessageDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addUserMessage(UserMessage usermessage) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(usermessage);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserMessage> listUserMessage() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from user_message where status = 1").list();
	}

	@Override
	public void removeUserMessage(Integer id) {
		// TODO Auto-generated method stub
		UserMessage usermessage = (UserMessage)sessionFactory.getCurrentSession().load(UserMessage.class, id);
		if(usermessage != null){
			if(usermessage.getStatus() == 1){
				usermessage.setStatus((byte) 0);
				sessionFactory.getCurrentSession().update(usermessage);
			}
		}
	}

}
