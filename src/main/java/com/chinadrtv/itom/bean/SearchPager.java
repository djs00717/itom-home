package com.chinadrtv.itom.bean;

/**
 * @param <C>  condition type;
 * @param <R>   result  type.
 */
public class SearchPager<C, R> extends Pager<R> {
	private C condition;

	public C getCondition() {
		return condition;
	}

	public void setCondition(C condition) {
		this.condition = condition;
	}
}
