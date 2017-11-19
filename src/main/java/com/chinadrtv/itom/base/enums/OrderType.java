package com.chinadrtv.itom.base.enums;
/**
 * 单据类型枚举
 * @author Fu Qinghui<qinghui.fu@capgemini.com>
 * @version 2013-5-16 下午3:28:21
 */
public enum OrderType {
	INSTORE("01"),
	OUTSTORE("28"),
	TEMPFEE("87");
	
	private final String desc;
	
	private OrderType(String desc){
		this.desc = desc;
	}
	
	public int getValue() {
		 return this.ordinal();
	}
	
	public String getDesc() {
		return desc;
	}
}
