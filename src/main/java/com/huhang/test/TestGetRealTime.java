package com.huhang.test;

import org.junit.Test;

import com.huhang.service.ArgService;

public class TestGetRealTime {
	@Test
	public void test() throws Exception{
		ArgService argService =new ArgService();
		String sql="select RealTime.group_id,DeviceGroup.name group_name,RealTime.device_id,Device.name device_name,RealTime.status,RealTime.error_code from RealTime,DeviceGroup,Device where RealTime.device_id=Device.id and RealTime.group_id=DeviceGroup.id and RealTime.group_id=000000 limit 1,3;";
		argService.getRealTimeStatus(sql);
		
	}
}
