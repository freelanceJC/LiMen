package edu.limen.dao;

import java.util.List;

import edu.limen.model.pojo.Device;

public interface IDeviceDAO {

	public void addDevice(Device device);
	
	public List<Device> listDevice();
	
	public void removeDevice(Integer id);
}
