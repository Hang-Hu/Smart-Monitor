package com.huhang.test;

import org.junit.Test;

import com.huhang.dao.DeviceGroupDao;
import com.huhang.dao.impl.DeviceGroupDaoImpl;
import com.huhang.entity.DeviceGroup;

public class TestGroupInsert {
	@Test
	public void testinsertGroup() throws Exception {
	// TODO Auto-generated method stub
	DeviceGroup group=new DeviceGroup();
	group.setId(000002);
	group.setName("Nanchang");
	DeviceGroupDao groupDao=new DeviceGroupDaoImpl();
	groupDao.addDeviceGroup(group);
}
}
