package com.huhang.test;


import org.junit.Test;

import com.huhang.dao.DeviceGroupDao;
import com.huhang.dao.impl.DeviceGroupDaoImpl;
import com.huhang.entity.DeviceGroup;

public class TestDeviceGroupFind{

	@Test
	public void test() throws Exception{
		DeviceGroupDao groupDao=new DeviceGroupDaoImpl();
		DeviceGroup group=groupDao.findDeviceGroup(000001);
		System.out.println(group.getId()+" "+group.getName());
	}

}
