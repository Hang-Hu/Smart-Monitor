package com.huhang.test;

import java.time.Duration;
import java.util.Date;

import org.junit.Test;

import com.huhang.dao.ErrorHistoryDao;
import com.huhang.dao.impl.ErrorHistoryDaoImpl;
import com.huhang.entity.ErrorHistory;

public class TestErrorHistoryInsert {
	@Test
	public void test() throws Exception{
		Date date=new Date();
		ErrorHistory errorHistory=new ErrorHistory();
		errorHistory.setDeviceId(20161112);
		errorHistory.setDuration(Duration.ofHours(1));
		errorHistory.setGroupId(000000);
		errorHistory.setTime(date);
		ErrorHistoryDao errorDao=new ErrorHistoryDaoImpl();
		errorDao.addErrorHistory(errorHistory);
	}
}
