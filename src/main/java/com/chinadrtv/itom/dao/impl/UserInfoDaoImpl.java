package com.chinadrtv.itom.dao.impl;

import com.chinadrtv.itom.base.dao.BaseHibernateDAO;
import com.chinadrtv.itom.dao.UserInfoDao;
import com.chinadrtv.itom.dto.UserInfoDto;
import com.chinadrtv.itom.model.UserInfo;

import java.util.List;

/**
 * Created by djs on 2017/11/15.
 */
public class UserInfoDaoImpl extends BaseHibernateDAO implements UserInfoDao {


    public UserInfoDto list(String loginName) {
        return  (UserInfoDto) super.get(UserInfoDto.class,loginName);
    }



}
