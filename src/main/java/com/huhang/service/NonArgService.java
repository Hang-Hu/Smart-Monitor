package com.huhang.service;

import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.huhang.dao.DeviceGroupDao;
import com.huhang.dao.impl.DeviceGroupDaoImpl;
import com.huhang.entity.DeviceGroup;
import com.huhang.entity.ErrorType;

public class NonArgService {
	public static String getGroups() throws Exception{
		DeviceGroupDao groupDao=new DeviceGroupDaoImpl();
		List<DeviceGroup> groups=groupDao.findAllDeviceGroups();
		Gson gson=new Gson();
		String jsonStr=gson.toJson(groups);
		System.out.println(jsonStr);
		return jsonStr;
	}

	public static String getErrorTypes(){
		List<ErrorType> types=new LinkedList<>();
		for(int i=0;i<4;i++){
			ErrorType type=new ErrorType(i);
			types.add(type);
		}
		types.add(new ErrorType(9));
		String jsonStr=new Gson().toJson(types);
		System.out.println(jsonStr);
		return jsonStr;
	}
}
