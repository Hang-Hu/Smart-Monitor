package com.huhang.test;
import org.junit.Test;

import com.huhang.dao.DeviceDao;
import com.huhang.dao.DeviceGroupDao;
import com.huhang.dao.impl.DeviceDaoImpl;
import com.huhang.dao.impl.DeviceGroupDaoImpl;
import com.huhang.entity.Device;
import com.huhang.entity.DeviceGroup;
public class TestDeviceInsert {
	@Test
	public void testDeviceInsert() throws Exception{
		Device device=new Device();
		device.setId(20161212);
		device.setGroupId(000000);
		device.setName("socket server");
		DeviceDao deviceDao=new DeviceDaoImpl();
		deviceDao.addDevice(device);
	}

}
