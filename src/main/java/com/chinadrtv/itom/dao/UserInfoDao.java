package com.chinadrtv.itom.dao;

import com.chinadrtv.itom.dto.UserInfoDto;
import com.chinadrtv.itom.model.UserInfo;

import java.util.List;

/**
 * Created by djs on 2017/11/14.
 */
public interface UserInfoDao  {
     UserInfoDto list(String loginName);
}
