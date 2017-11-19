package com.chinadrtv.itom.base.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;

/**
 * Created by djs on 2017/11/18.
 */
public abstract class BaseHibernateDAO {
    protected void add(Object object) {
        Transaction tx = null;

        // 获取session
        Session session = HibernateSessionFactory.getSession();

        try {
            // 开始事务
            tx = session.beginTransaction();

            // 持久化操作
            session.save(object);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                // 回滚事务
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            // 关闭session
            session.close();
        }
    }


    protected Object get(Class cla, Serializable id) {
        Object obj = null;

        Session session = HibernateSessionFactory.getSession();
        try {
            obj = session.get(cla, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return obj;
    }

    protected void delete(Object object) {

        Transaction tx = null;

        Session session = HibernateSessionFactory.getSession();

        try {
            tx = session.beginTransaction();
            session.delete(object);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    protected void update(Object object) {
        Transaction tx = null;
        Session session = HibernateSessionFactory.getSession();

        try {
            tx = session.beginTransaction();
            session.update(object);

            tx.commit();
        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
