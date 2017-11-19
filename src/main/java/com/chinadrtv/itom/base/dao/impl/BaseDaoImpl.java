package com.chinadrtv.itom.base.dao.impl;

import com.chinadrtv.itom.base.dao.BaseDAO;
import com.chinadrtv.itom.base.dto.TableLock;
import com.chinadrtv.itom.util.Reflections;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.orm.hibernate3.SessionFactoryUtils.getSession;


/**
 * @param <T>
 * @param <PK>
 */
public abstract class BaseDaoImpl<T, PK extends Serializable> extends HibernateDaoSupport implements BaseDAO<T,PK>{
    protected Class<T> entityClass;

    protected final Log log = LogFactory.getLog(this.getClass());

    @Resource(name="sessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @SuppressWarnings("unchecked")
    public BaseDaoImpl(){
        this.entityClass = Reflections.getSuperClassGenricType(getClass());
    }


    public void save(T object) {

    }

    public void update(T object) {

    }

    public void refresh(T object) {

    }

    public T get(PK id) {
        return null;
    }

    public T load(PK id) {
        return null;
    }

    public void delete(T object) {

    }

    public List<T> getAll() {
        return null;
    }

    public void delete(PK id) {

    }

    public T findUniqueBy(String propertyName, Object value) {
        return null;
    }

    public List<T> findBy(String propertyName, Object value) {
        return null;
    }

    public long getSequence(String seqName) {
        return 0;
    }

    public String getDocNo(int type) throws Exception {
        return null;
    }

    public void insertSQL(String tableName, Map<String, Object> keyValues) throws Exception {

    }

    public void updateSQL(String tableName, Map<String, Object> keyValues, Map<String, Object> where) throws Exception {

    }

    public void deleteSQL(String tableName, Map<String, Object> where) throws Exception {

    }

    public TableLock getOtherLockOrSetMyLock(String tableName, long ruid, String username) throws Exception {
        return null;
    }

    public void clearMyLock(String tableName, long ruid, String username) throws Exception {

    }

    public TableLock getOtherLock(String tableName, long ruid, String username) {
        return null;
    }

    public String executeProcedures(String name, LinkedHashMap<String, Object> params) throws Exception {
        return null;
    }
}
