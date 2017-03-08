package com.huhang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.huhang.dao.RealTimeDao;
import com.huhang.entity.ErrorType;
import com.huhang.entity.RealTimeRecord;
import com.huhang.utils.DBUtils;

public class RealTimeDaoImpl implements RealTimeDao {

	@Override
	public void addRealTimeRecord(RealTimeRecord record) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=DBUtils .getConnection();
		PreparedStatement ps=conn.prepareStatement("insert into RealTime values(?,?,?,?);");
		ps.setInt(1, record .getDeviceId());
		ps.setInt(2, record.getGroupId());
		ps.setInt(3, record.getStatus());
		ps.setInt(4, 9);
		ps.executeUpdate();
		DBUtils.closeAll(null, ps, conn);
	}

	@Override
	public List<RealTimeRecord> findRealTimeRecords(String sql) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConnection();
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		List<RealTimeRecord> records=new LinkedList<>();
		while(rs.next()){
			RealTimeRecord record=new RealTimeRecord();
			record.setGroupId(rs.getInt("group_id"));
			record.setGroupName(rs.getString("group_name"));
			record.setDeviceId(rs.getInt("device_id"));
			record.setDeviceName(rs.getString("device_name"));
			record.setStatus(rs.getInt("status"));
			record.setErrorMsg(new ErrorType(rs.getInt("error_code")).getName());
			records.add(record);
		}
		return records;
	}

}
