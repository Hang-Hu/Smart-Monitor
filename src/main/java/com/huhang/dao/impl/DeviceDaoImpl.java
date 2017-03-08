package com.huhang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.huhang.dao.DeviceDao;
import com.huhang.entity.Device;
import com.huhang.utils.DBUtils;

public class DeviceDaoImpl implements DeviceDao{

	@Override
	public void addDevice(Device device) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConnection();
		PreparedStatement ps=conn.prepareStatement("insert into Device values(?,?,?)");
		ps.setInt(1, device.getId());
		ps.setInt(2, device.getGroupId());
		ps.setString(3, device.getName());
		ps.executeUpdate();
		DBUtils.closeAll(null, ps, conn);
	}

	@Override
	public Device findDevice(int deviceId,int groupId) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConnection();
		PreparedStatement ps=conn.prepareStatement("select * from Device where id=? and group_id=?");
		ps.setInt(1, deviceId);
		ps.setInt(2, groupId);
		ResultSet rs=ps.executeQuery();
		Device device=new Device();
		if(rs.next()){
			device.setId(rs.getInt("id"));
			device.setGroupId(rs.getInt("group_id"));
			device.setName(rs.getString("name"));
		}
		DBUtils.closeAll(rs, ps, conn);
		return device;
	}

	@Override
	public List<Device> findDevices(int groupId) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConnection();
		PreparedStatement ps=conn.prepareStatement("select * from Device where group_id=?");
		ps.setInt(1, groupId);
		ResultSet rs=ps.executeQuery();
		List<Device> devices=new LinkedList<>();
		while(rs.next()){
			Device device=new Device();
			device.setId(rs.getInt("id"));
			device.setGroupId(rs.getInt("group_id"));
			device.setName(rs.getString("name"));
			devices.add(device);
		}
		DBUtils.closeAll(rs, ps, conn);
		return devices;
	}

	@Override
	public void modifyDeviceName(Device device) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConnection();
		PreparedStatement ps=conn.prepareStatement("update Device set `name`=? where id=? and group_id=?");
		ps.setString(1, device.getName());
		ps.setInt(2, device.getId());
		ps.setInt(3, device.getGroupId());
		ps.executeUpdate();
		DBUtils.closeAll(null, ps, conn);
	}

}
