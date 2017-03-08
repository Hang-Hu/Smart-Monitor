package com.huhang.dao;

import java.util.List;

import com.huhang.entity.Device;

public interface DeviceDao {
	public void addDevice(Device device) throws Exception;
	public Device findDevice(int deviceId,int groupId)throws Exception;
	public List<Device> findDevices(int groupId)throws Exception;
	public void modifyDeviceName(Device device) throws Exception;

}
