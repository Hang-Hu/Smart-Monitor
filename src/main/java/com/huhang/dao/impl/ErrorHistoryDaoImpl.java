package com.huhang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.huhang.dao.ErrorHistoryDao;
import com.huhang.entity.ErrorHistory;
import com.huhang.entity.ErrorType;
import com.huhang.utils.DBUtils;


public class ErrorHistoryDaoImpl implements ErrorHistoryDao{

	@Override
	public void addErrorHistory(ErrorHistory errorHistory) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConnection();
		PreparedStatement ps=conn.prepareStatement("insert into ErrorHistory values(default,?,?,?,?,?,?)");
		ps.setInt(1, errorHistory.getDeviceId());
		ps.setInt(2, errorHistory.getGroupId());
		ps.setInt(3, 1);
		ps.setInt(4, 1);//error_code
		ps.setTimestamp(5, new Timestamp(errorHistory.getTime().getTime()));
		ps.setTimestamp(6, new Timestamp(errorHistory.getTime().getTime()+errorHistory.getDuration().getSeconds()*1000));
		ps.executeUpdate();
		DBUtils.closeAll(null, ps, conn);
		
	}

/*	@Override
	public List<ErrorHistory> findErrorHistories(int deviceId) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConnection();
		PreparedStatement ps=conn.prepareStatement("select * from Log where device_id=?");
		ps.setInt(1, deviceId);
		ResultSet rs=ps.executeQuery();
		List<Log> logs=new LinkedList<>();
		while(rs.next()){
			Log log=new Log();
			log.setDeviceId(rs.getInt("device_id"));
			log.setTime((Date)rs.getTimestamp("time"));
			log.setStatus(rs.getInt("status"));
			log.setErrorCode(rs.getInt("error_code"));
			logs.add(log);
		}
		return logs;
	}*/

	@Override
	public List<ErrorHistory> findErrorHistory(String sql) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConnection();		
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		List<ErrorHistory> errorHistories=new LinkedList<>();
		while(rs.next()){
			ErrorHistory errorHistory=new ErrorHistory();
			errorHistory.setGroupId(rs.getInt("group_id"));
			errorHistory.setGroupName(rs.getString("group_name"));
			errorHistory.setDeviceId(rs.getInt("device_id"));
			errorHistory.setDeviceName(rs.getString("device_name"));
			errorHistory.setTime(new Date(rs.getTimestamp("start").getTime()));
			errorHistory.setErrorMsg(new ErrorType(rs.getInt("error_code")).getName());
			Duration duration=Duration.ofMillis(rs.getTimestamp("end_time").getTime()-rs.getTimestamp("start").getTime());
			errorHistory.setDuration(duration);
			errorHistories.add(errorHistory);
		}
		return errorHistories;
	}



}
