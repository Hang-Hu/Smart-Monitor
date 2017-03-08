package com.huhang.dao;

import java.util.List;

import com.huhang.entity.DeviceGroup;

public interface DeviceGroupDao {
	public void addDeviceGroup(DeviceGroup deviceGroup) throws Exception;
	public DeviceGroup findDeviceGroup(int groupId)throws Exception;
	public List<DeviceGroup> findAllDeviceGroups()throws Exception;
	public void modifyDeviceGroupName(DeviceGroup group) throws Exception;

}
