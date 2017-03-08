package com.huhang.service;

import java.util.List;

import com.google.gson.Gson;
import com.huhang.dao.DeviceDao;
import com.huhang.dao.ErrorHistoryDao;
import com.huhang.dao.RealTimeDao;
import com.huhang.dao.impl.DeviceDaoImpl;
import com.huhang.dao.impl.ErrorHistoryDaoImpl;
import com.huhang.dao.impl.RealTimeDaoImpl;
import com.huhang.entity.Device;
import com.huhang.entity.ErrorHistory;
import com.huhang.entity.RealTimeRecord;
import com.huhang.entity.User;

public class ArgService {
	
	public String getDevices(int groupId) throws Exception{
		DeviceDao deviceDao=new DeviceDaoImpl();
		List<Device> devices=deviceDao.findDevices(groupId);
		String jsonStr=new Gson().toJson(devices);
		System.out.println(jsonStr);
		return jsonStr;
	}
	public String getRealTimeStatus(String sql) throws Exception{
		RealTimeDao realTimeDao=new RealTimeDaoImpl();
		List<RealTimeRecord> records=realTimeDao.findRealTimeRecords(sql);
		String jsonstr=new Gson().toJson(records);
		System.out.println(jsonstr);
		return jsonstr;

	}
	public String getErrorHistory(String sql) throws Exception{
		ErrorHistoryDao errDao=new ErrorHistoryDaoImpl();
		List<ErrorHistory> errorHistories=errDao.findErrorHistory(sql);
		String jsonStr=new Gson().toJson(errorHistories);
		System.out.println(jsonStr);
		return jsonStr;

	}
	public boolean doLogin(String name,String password){
		User user=new User();
		user.setName(name);
		user.setPassword(password);
		return user.validate();
	}
}
