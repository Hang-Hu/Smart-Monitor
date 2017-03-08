package com.huhang.dao;

import java.util.List;

import com.huhang.entity.RealTimeRecord;

public interface RealTimeDao {
	public void addRealTimeRecord(RealTimeRecord record)throws Exception;
	public List<RealTimeRecord> findRealTimeRecords(String sql)throws Exception;
}
