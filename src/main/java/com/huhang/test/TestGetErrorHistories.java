package com.huhang.test;

import org.junit.Test;

import com.huhang.service.ArgService;

public class TestGetErrorHistories {
	@Test
	public void test() throws Exception{
		ArgService argService =new ArgService();
		String sql="select DeviceGroup.id group_id,DeviceGroup.name group_name,Device.id device_id,Device.name device_name,ErrorHistory.start_time start,ErrorHistory.end_time,ErrorHistory.error_code from DeviceGroup,Device,ErrorHistory where DeviceGroup.id=Device.group_id and ErrorHistory.device_id=Device.id and ErrorHistory.group_id=Device.group_id and ErrorHistory.group_id=000000 and device_id=20161112 and error_code=1 and start_time between now()-interval 31 day and now() limit 1,2;";
		argService.getErrorHistory(sql);
	}
}
