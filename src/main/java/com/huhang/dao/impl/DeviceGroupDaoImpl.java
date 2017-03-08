package com.huhang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.huhang.dao.DeviceGroupDao;
import com.huhang.entity.DeviceGroup;
import com.huhang.utils.DBUtils;

public class DeviceGroupDaoImpl implements DeviceGroupDao{

	@Override
	public void addDeviceGroup(DeviceGroup deviceGroup) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConnection();
		PreparedStatement ps=conn.prepareStatement("insert into DeviceGroup values(?,?)");
		ps.setInt(1, deviceGroup.getId());
		ps.setString(2, deviceGroup.getName());
		ps.executeUpdate();
		DBUtils.closeAll(null, ps, conn);
	}

	@Override
	public DeviceGroup findDeviceGroup(int groupId) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConnection();
		PreparedStatement ps=conn.prepareStatement("select * from DeviceGroup where id=?");
		ps.setInt(1, groupId);
		ResultSet rs=ps.executeQuery();
		DeviceGroup deviceGroup=new DeviceGroup();
		if(rs.next()){
			deviceGroup.setId(rs.getInt("id"));
			deviceGroup.setName(rs.getString("name"));
		}
		DBUtils.closeAll(rs, ps, conn);
		return deviceGroup;
	}

	@Override
	public List<DeviceGroup> findAllDeviceGroups() throws Exception {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConnection();
		PreparedStatement ps=conn.prepareStatement("select * from DeviceGroup");
		ResultSet rs=ps.executeQuery();
		List<DeviceGroup> groups=new LinkedList<>();
		while(rs.next()){
			DeviceGroup group=new DeviceGroup();
			group.setId(rs.getInt("id"));
			group.setName(rs.getString("name"));
			groups.add(group);
			//System.out.println(group.getId()+" "+group.getName());
		}
		DBUtils.closeAll(rs, ps, conn);
		return groups;
	}

	@Override
	public void modifyDeviceGroupName(DeviceGroup group) throws Exception {
		// TODO Auto-generated method stub
		String newName=group.getName();
		int groupId=group.getId();
		Connection conn=DBUtils .getConnection();
		PreparedStatement ps=conn.prepareStatement("update DeviceGroup set name=? where id=?");
		ps.setString(1, newName);
		ps.setInt(2, groupId);
		System.out.println(ps);
		ps.executeUpdate();
		DBUtils.closeAll(null, ps, conn);
	}

}
