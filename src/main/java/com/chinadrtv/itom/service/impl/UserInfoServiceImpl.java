package com.chinadrtv.itom.service.impl;

import com.chinadrtv.itom.dao.UserInfoDao;
import com.chinadrtv.itom.dao.impl.UserInfoDaoImpl;
import com.chinadrtv.itom.dto.UserInfoDto;
import com.chinadrtv.itom.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * Created by djs on 2017/11/8.
 */
@Service("UserInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    public boolean checkUser(String loginName, String passWord) {
        boolean flag=false;
        UserInfoDao dao = new UserInfoDaoImpl();
        UserInfoDto list = dao.list(loginName);
        if(!list.equals(null)){
            flag=true;
        }

        return flag;
    }
}
