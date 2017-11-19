package com.chinadrtv.itom.base.enums;



public enum ScmSelectUrl{

	
	test("../balance/test");

	private String desc;

	/**
	 * @param index
	 * @param name
	 */
	private ScmSelectUrl(String desc) {
		this.desc = desc;
	}

	public static String getUrl(String name) {
		for (ScmSelectUrl selectUrl : ScmSelectUrl.values()) {
			if (name.equals(selectUrl.name())){
				return selectUrl.getDesc();
			}
		}
		return null;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
