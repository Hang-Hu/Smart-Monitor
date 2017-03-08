package com.huhang.test;

import org.junit.Test;

import com.huhang.service.ArgService;

public class TestGetDevices {
	@Test
	public void test() throws Exception{
		ArgService argService =new ArgService();
		argService.getDevices(000000);
	}
}
