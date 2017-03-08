package com.huhang.test;

import org.junit.Test;

import com.huhang.service.NonArgService;

public class TestGetGroups {
	@Test
	public void test() throws Exception{
		System.out.println(NonArgService.getGroups());
		
	}
}
