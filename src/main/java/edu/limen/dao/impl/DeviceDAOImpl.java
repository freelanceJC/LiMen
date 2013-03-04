package edu.limen.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.limen.model.pojo.Device;
import edu.limen.dao.IDeviceDAO;

@Repository
public class DeviceDAOImpl implements IDeviceDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addDevice(Device device){
		sessionFactory.getCurrentSession().save(device);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Device> listDevice(){
		return sessionFactory.getCurrentSession().createQuery("from device where status = 1").list();
	}
	
	@Override
	public void removeDevice(Integer id) {
		// TODO Auto-generated method stub
		Device device = (Device)sessionFactory.getCurrentSession().load(Device.class, id);
		
//		if(device != null){
//			if(device.getStatus() == 1){
//				device.setStatus((byte)0);
//				sessionFactory.getCurrentSession().update(device);
//			}
//		}
	}

}
