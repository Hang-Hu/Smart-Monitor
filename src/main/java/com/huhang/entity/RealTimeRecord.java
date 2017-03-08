package com.huhang.entity;

import com.google.gson.annotations.SerializedName;

public class RealTimeRecord {
	@SerializedName("group_id")
	private int groupId;
	@SerializedName("group_name")
	private String groupName;
	@SerializedName("device_id")
	private int deviceId;
	@SerializedName("device_name")
	private String deviceName;
	private int status;
	@SerializedName("error_msg")
	private String errorMsg;
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
