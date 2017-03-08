package com.huhang.entity;

import java.time.Duration;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class ErrorHistory {
	@SerializedName("group_id")
	private int groupId;
	@SerializedName("group_name")
	private String groupName;
	@SerializedName("device_id")
	private int deviceId;
	@SerializedName("device_name")
	private String deviceName;
	@SerializedName("start")
	private Date time;
	@SerializedName("error_msg")
	private String errorMsg;
	@SerializedName("last")
	private Duration duration;
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Duration getDuration() {
		return duration;
	}
	public void setDuration(Duration duration) {
		this.duration = duration;
	}

}
