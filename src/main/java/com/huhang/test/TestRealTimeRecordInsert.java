package com.huhang.test;

import org.junit.Test;

import com.huhang.dao.RealTimeDao;
import com.huhang.dao.impl.RealTimeDaoImpl;
import com.huhang.entity.RealTimeRecord;

public class TestRealTimeRecordInsert {
	@Test
	public void test() throws Exception{
		RealTimeRecord record=new RealTimeRecord();
		record.setDeviceId(20161212);
		record.setGroupId(000000);
		record.setStatus(1);
		RealTimeDao rtDao=new RealTimeDaoImpl();
		rtDao.addRealTimeRecord(record);
	}
}
