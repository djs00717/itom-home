package com.chinadrtv.itom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by djs on 2017/11/11.
 */
@Entity
@Table(
        name = "userinfo",
        schema = "aco_scm"
)
public class UserInfo {
    @Id
    @Column(           name="LOGINNAME"    )
    String loginName;
    @Column(
            name="PASSWORD"
    )
    String passWord;
    @Column(  name="USERNAME" )
    String userName;

    @Column(name="department")
    String department;

    @Column(name="isblocked")
    Integer isBlocked;

    public UserInfo(){

    }


    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }


    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(Integer isBlocked) {
        this.isBlocked = isBlocked;
    }
}
