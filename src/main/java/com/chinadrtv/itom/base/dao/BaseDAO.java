package com.chinadrtv.itom.base.dao;

import com.chinadrtv.itom.base.dto.TableLock;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 所有dao接口的父接口，定义通用操作
 * @author Fu Qinghui<qinghui.fu@capgemini.com>
 * @version 2013-5-11 下午12:04:19
 * @param <T>
 * @param <PK>
 */

 public interface BaseDAO<T, PK extends Serializable> {
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

	 	/**
	 	 * 获取某Sequence
	 	 * @param seqName
	 	 * @return
	 	 */
		long getSequence(String seqName);

		/**
		 * 获取docNo
		 * @param type eg:doc53bf type=53
		 * @return docNo
		 * @throws Exception
		 */
		String getDocNo(int type) throws Exception;

		void insertSQL(String tableName, Map<String, Object> keyValues) throws Exception;
		void updateSQL(String tableName, Map<String, Object> keyValues, Map<String, Object> where) throws Exception;
		void deleteSQL(String tableName, Map<String, Object> where) throws Exception;
		TableLock getOtherLockOrSetMyLock(String tableName, long ruid, String username) throws Exception;
		void clearMyLock(String tableName, long ruid, String username) throws Exception;
		TableLock getOtherLock(String tableName, long ruid, String username);
		/***
		 * 执行存储过程，参数不包括返回值
		 * 要求存储过程的返回值在最后，且只有一个返回值
		 * @param name
		 * @param params
		 * @param result
		 * @return
		 * @throws Exception
		 */
		String executeProcedures(String name, LinkedHashMap<String, Object> params) throws Exception;
}
