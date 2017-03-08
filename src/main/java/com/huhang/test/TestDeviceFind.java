package com.huhang.test;

import org.junit.Test;

import com.huhang.dao.DeviceDao;
import com.huhang.dao.impl.DeviceDaoImpl;
import com.huhang.entity.Device;

public class TestDeviceFind {
	@Test
	public void testDeviceFind() throws Exception{
		DeviceDao deviceDao=new DeviceDaoImpl();
		Device device=deviceDao.findDevice(20161112, 000000);
		System.out.println(device.getId()+" "+device.getGroupId()+" "+device.getName());
	}
}
