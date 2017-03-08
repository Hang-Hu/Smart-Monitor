package com.huhang.dao;

import java.util.List;

import com.huhang.entity.ErrorHistory;

public interface ErrorHistoryDao {
	public void addErrorHistory(ErrorHistory errorHistory) throws Exception;
/*	public List<ErrorHistory> findErrorHistories(int deviceId)throws Exception;
*/	public List<ErrorHistory> findErrorHistory(String sql) throws Exception;
}
