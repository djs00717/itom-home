package com.chinadrtv.itom.dao.impl;

import com.chinadrtv.itom.base.dao.BaseHibernateDAO;
import com.chinadrtv.itom.dao.DjsaaDao;
import com.chinadrtv.itom.model.Djsaa;
import org.hibernate.Session;

import static com.chinadrtv.itom.base.dao.HibernateSessionFactory.getSession;

/**
 * Created by djs on 2017/11/18.
 */
public class DjsaaDaoImpl extends BaseHibernateDAO implements DjsaaDao {
    public void add(Djsaa djsaa) {
        super.add(djsaa);

    }

    public void delete(Djsaa djsaa) {
        super.delete(djsaa);
    }

    public Djsaa load(String aa) {
        return (Djsaa) super.get(Djsaa.class,aa);
    }

    public void update(Djsaa djsaa) {
        super.update(djsaa);
    }
}
