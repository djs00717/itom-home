package com.chinadrtv.itom.base.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by djs on 2017/11/18.
 */
public class HibernateSessionFactory {
    private static Configuration configure;
    private static SessionFactory sessionFactory;

    static {
        configure = new Configuration().configure();
        sessionFactory = configure.buildSessionFactory();
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
