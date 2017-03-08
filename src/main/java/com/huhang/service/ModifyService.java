package com.huhang.service;

import com.google.gson.Gson;
import com.huhang.dao.DeviceDao;
import com.huhang.dao.DeviceGroupDao;
import com.huhang.dao.impl.DeviceDaoImpl;
import com.huhang.dao.impl.DeviceGroupDaoImpl;
import com.huhang.entity.Device;
import com.huhang.entity.DeviceGroup;
import com.huhang.entity.Success;

public class ModifyService {
	public String modifyGroupName(int groupId,String groupName){
		DeviceGroupDao groupDao=new DeviceGroupDaoImpl();
		DeviceGroup group=new DeviceGroup();
		group.setId(groupId);
		group.setName(groupName);
		try {
			groupDao.modifyDeviceGroupName(group);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Success success=new Success();
		success.setSuccess(true);
		return new Gson().toJson(success);
	}
	public String modifyDeviceName(int deviceId,int groupId,String deviceName){
		Device device=new Device();
		device.setGroupId(groupId);
		device.setId(deviceId);
		device.setName(deviceName);
		DeviceDao deviceDao=new DeviceDaoImpl();
		try {
			deviceDao.modifyDeviceName(device);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Success success=new Success();
		success.setSuccess(true);
		return new Gson().toJson(success);
	}
}
