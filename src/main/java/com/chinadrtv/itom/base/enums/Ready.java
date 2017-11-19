package com.chinadrtv.itom.base.enums;

/**
 * 有效标志枚举类
 * @author Fu Qinghui<qinghui.fu@capgemini.com>
 * @version 2013-5-16 下午3:06:25
 */
public enum Ready {
	NO("0","未确认","未结算"),
	YES("1","已确认","已结算");
	private final String desc;
	/**是否确认*/
	private final String status;
	/**是否结算*/
	private final String balance;
	private Ready(String desc, String status, String balance){
		this.desc = desc;
		this.status = status;
		this.balance = balance;
	}
	
	public int getValue() {
		 return this.ordinal();
	}
	
	public String getDesc() {
		return desc;
	}
	public String getStatus(){
		return status;
	}
	public String getBalance(){
		return balance;
	}
	
	public static Ready getReady(String desc) {
		for (Ready ready : Ready.values()) {
			if (desc.equals(ready.desc)){
				return ready;
			}
		}
		return null;
	}
}
