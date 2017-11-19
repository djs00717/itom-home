package com.chinadrtv.itom.base.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, PK extends Serializable> {
	/**
 	 * 保存对象
 	 * @param object
 	 */
 	public void save(T object);
 	/**
 	 * 更新对象
 	 * @param object
 	 */
 	public void update(T object);
 	
 	/**
 	 * 更新对象
 	 * @param object
 	 */
 	public void refresh(T object);
 	
 	/**
 	 * 获取对象
 	 * @param id
 	 * @return
 	 */
 	public T get(PK id);
 	
 	/**
 	 * 加载对象
 	 * @param id
 	 * @return
 	 */
 	public T load(PK id);
 	
 	/**
 	 * 删除对象
 	 * @param object
 	 */
 	public void delete(T object);
 	
 	/**
 	 * 获取所有的对象列表
 	 * @return
 	 */
 	public List<T> getAll();
 	
 	/**
 	 * 删除对象
 	 * @param id
 	 */
 	public void delete(PK id);
 	
 	/**
 	 * 按属性查找唯一对象, 匹配方式为相等.
 	 * @param propertyName
 	 * @param value
 	 * @return
 	 */
 	public T findUniqueBy(final String propertyName, final Object value);
 	
	/**
 	 * 按属性查找对象, 匹配方式为相等.
 	 * @param propertyName
 	 * @param value
 	 * @return
 	 */
 	public List<T> findBy(final String propertyName, final Object value);
}
