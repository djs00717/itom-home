package com.chinadrtv.itom.dao;

import com.chinadrtv.itom.model.Djsaa;

/**
 * Created by djs on 2017/11/18.
 */
public interface DjsaaDao {
    void add(Djsaa djsaa);
    void delete(Djsaa djsaa);

    Djsaa load(String aa);

    void update(Djsaa djsaa);
}
