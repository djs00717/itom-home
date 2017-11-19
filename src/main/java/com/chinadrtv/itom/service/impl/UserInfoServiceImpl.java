package com.chinadrtv.itom.service.impl;

import com.chinadrtv.itom.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * Created by djs on 2017/11/8.
 */
@Service("UserInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    public boolean checkUser(String userName, String passWord) {
        return false;
    }
}
