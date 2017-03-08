package com.huhang.entity;

public class ErrorType {
	private int id;
	private String name;
	public ErrorType(int id){
		this.id=id;
		switch(this.id){
			case 0: name="没有错误";
			break;
			case 1: name="失去连接";
			break;
			case 2: name="权限不足";
			break;
			case 3: name="无效资源";
			break;
			case 9: name="未知错误";
			break;
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

}
