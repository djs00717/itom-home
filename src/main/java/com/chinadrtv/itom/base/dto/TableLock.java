package com.chinadrtv.itom.base.dto;

import java.util.Date;

public class TableLock {
	private String tableName;
	private long ruid;
	private String username;
	private Date lockDate;
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public long getRuid() {
		return ruid;
	}
	public void setRuid(long ruid) {
		this.ruid = ruid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getLockDate() {
		return lockDate;
	}
	public void setLockDate(Date lockDate) {
		this.lockDate = lockDate;
	}
}
