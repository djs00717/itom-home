package com.chinadrtv.itom.base.enums;

/**
 * 审核,对账 标志枚举类
 * @author Fu Qinghui<qinghui.fu@capgemini.com>
 * @version 2013-5-16 下午3:06:25
 */
public enum Valid {
	NO("0","未对账","未对账"),
	YES("1","未付款","已对账"),
	CLOSING("2","已结账","已结账");
	private final String desc;
	private final String flag;
	private final String secondDesc;
	
	private Valid(String flag, String desc, String secondeDesc){
		this.desc = desc;
		this.flag = flag;
		this.secondDesc = secondeDesc;
	}
	
	public int getValue() {
		 return this.ordinal();
	}
	
	public String getDesc() {
		return desc;
	}
	public String getFlag(){
		return flag;
	}
	public String getSecondDesc(){
		return secondDesc;
	}
	public static Valid getValid(String flag) {
		for (Valid valid : Valid.values()) {
			if (flag.equals(valid.flag)){
				return valid;
			}
		}
		return null;
	}
}
