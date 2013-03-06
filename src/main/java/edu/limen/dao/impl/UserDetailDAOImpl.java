package edu.limen.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.limen.dao.IUserDetailDAO;
import edu.limen.model.pojo.Group;
import edu.limen.model.pojo.UserDetail;

@Repository
public class UserDetailDAOImpl implements IUserDetailDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addUserDetail(UserDetail userdetail) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(userdetail);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserDetail> listUserDetail() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from user_detail where status = 1").list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public UserDetail listActiveUserDetailByUserId(final Integer userId) {
		List<UserDetail> userDetailList = sessionFactory.getCurrentSession()
				.createQuery("from UserDetail where mod(status, :status) = 1 and id = :uid order by realNameString")
				.setInteger("status", 2)
				.setInteger("uid", userId).list();
		return userDetailList.isEmpty() ? null : userDetailList.get(0);
	}	

	@Override
	public void removeUserDetail(Integer id) {
		// TODO Auto-generated method stub
		UserDetail userdetail = (UserDetail)sessionFactory.getCurrentSession().load(UserDetail.class, id);
		
		if(userdetail != null){
			if(userdetail.getStatus() == 1){
				userdetail.setStatus((byte) 0);
				sessionFactory.getCurrentSession().update(userdetail);
			}
		}
	}
	


}
