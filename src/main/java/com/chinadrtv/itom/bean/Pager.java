package com.chinadrtv.itom.bean;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import java.util.ArrayList;
import java.util.List;

public class Pager<T> {

	private List<T> result;
	// current page no.
	private int currentPage = 1;
	// page size
	private int pageSize = 20;
	// total pages
	private int totalPages;
	// total record size
	private int totalSize;
	/**
	 * 排序字段名称,多个字段中间使用,分隔
	 */
	private String orderProperty = "";
	/**
	 * 排序方式asc或desc,多个字段中间使用,分隔
	 */
	private String order = "";

	/**
	 * 是否计算总数
	 */
	private boolean countTotal = true;
	
	private int offset;
	private boolean notPage = false;
	
	public boolean isNotPage() {
		return notPage;
	}

	public void setNotPage(boolean notPage) {
		this.notPage = notPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}
	public boolean isCountTotal() {
		return countTotal;
	}
	public void setCountTotal(boolean countTotal) {
		this.countTotal = countTotal;
	}

	/**
	 * According to total size and page size, rebuild current page and total
	 * pages.
	 * 
	 * @Date : 2012-11-19
	 * @param totalSize
	 *            - total size of records
	 */
	public void rebuild(int totalSize) {
		setTotalSize(totalSize);
		setTotalPages((totalSize - 1) / getPageSize() + 1);
		if (this.currentPage < 1) {
			setCurrentPage(1);
		}
		if (this.currentPage > this.totalPages) {
			setCurrentPage(this.totalPages);
		}
		this.offset = (currentPage - 1) * pageSize;

	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	public String getOrderProperty() {
		return orderProperty;
	}
	public void setOrderProperty(String orderProperty) {
		this.orderProperty = orderProperty;
	}
	public String getOrder() {
		return order;
	}
	/**
	 * 根据当前页获取记录开始号
	 * @return
	 */
	public int getFirstResult(){
		return (getCurrentPage() - 1) * getPageSize();
	}
	/**
	 * 是否设置了排序属性
	 * @return
	 */
	public boolean isOrderBySetted(){
		return StringUtils.isNotBlank(this.order) && StringUtils.isNotBlank(this.orderProperty);
	}
	
	public void setOrder(String order) {
		String lowcaseOrderDir = StringUtils.lowerCase(order);
		//检查order字符串的合法值
		String[] orderDirs = StringUtils.split(lowcaseOrderDir, ',');
		for (String orderDirStr : orderDirs) {
			if (!StringUtils.equals(Sort.DESC, orderDirStr) && !StringUtils.equals(Sort.ASC, orderDirStr)) {
				throw new IllegalArgumentException("排序方向" + orderDirStr + "不是合法值");
			}
		}
		this.order = lowcaseOrderDir;
	}
	/**
	 * 获得排序参数.
	 * @return
	 */
	public List<Sort> getSort() {
		String[] orderBys = StringUtils.split(this.orderProperty, ',');
		String[] orderDirs = StringUtils.split(this.order, ',');
		Validate.isTrue(orderBys.length == orderDirs.length, "分页多重排序参数中,排序字段与排序方向的个数不相等");

		List<Sort> orders = new ArrayList<Sort>();
		for (int i = 0; i < orderBys.length; i++) {
			orders.add(new Sort(orderBys[i], orderDirs[i]));
		}
		return orders;
	}
	
	/**
	 * 复制pager的基本信息，totalRecords,currentPage,pageSize,orderProperty,order,countTotal
	 * @param pager
	 * @return
	 */
	public static <X,M> Pager<M> cloneFromPager(Pager<X> pager){
		Pager<M> result = new Pager<M>();
		result.setCountTotal(pager.isCountTotal());
		result.setCurrentPage(pager.getCurrentPage());
		result.setOrder(pager.getOrder());
		result.setOrderProperty(pager.getOrderProperty());
		result.setPageSize(pager.getPageSize());
		result.setTotalSize(pager.getTotalSize());
		return result;
	}
	
	
	/**
	 * 复制pager的基本信息，totalRecords,currentPage,pageSize,orderProperty,order,countTotal,
	 * 重新设置records，totalRecords属性
	 * @param pager
	 * @return
	 */
	public static <X> Pager<X> cloneFromPager(Pager<X> pager,int totalRecords,List<X> records){
		Pager<X> result = cloneFromPager(pager);
		result.setTotalSize(totalRecords);
		result.setResult(records);
		return result;
	}
	
	public static class Sort {
		public static final String ASC = "asc";
		public static final String DESC = "desc";

		private final String property;
		private final String dir;

		public Sort(String property, String dir) {
			this.property = property;
			this.dir = dir;
		}

		public String getProperty() {
			return property;
		}

		public String getDir() {
			return dir;
		}
	}
}
