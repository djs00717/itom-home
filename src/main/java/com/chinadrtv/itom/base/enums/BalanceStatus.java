package com.chinadrtv.itom.base.enums;

/**
 * 有效标志枚举类
 * @author Fu Qinghui<qinghui.fu@capgemini.com>
 * @version 2013-5-16 下午3:06:25
 */
public enum BalanceStatus {
	CHECK_PASS("20","审核通过"),
	ACCOUNT_CONFIRM("30","对账确认"),
	ADVANCE_PAYAMENT("50","付预付款"),
	ESTIMATE_PAYAMENT("60","暂估付款"),
	ALREADY_PAY("70","付款完毕"),
	MONEY_CONFIRM("80","收款确认"),
	BALANCE_COMPLETE("85","结算完成"),
	TERMINATE("90","终止");
	
	private final String desc;
	private final String status;
	private BalanceStatus(String status, String desc){
		this.desc = desc;
		this.status = status;
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
	
	public static BalanceStatus getReady(String status) {
		for (BalanceStatus ready : BalanceStatus.values()) {
			if (status.equals(ready.status)){
				return ready;
			}
		}
		return null;
	}
}
