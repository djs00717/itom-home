package com.chinadrtv.itom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by djs on 2017/11/18.
 */
@Entity
@Table(name="DJS_AA" )
public class Djsaa {
    @Id  // 指定该列为主键。
    @Column(name = "aa") //指定变量对应的数据库表的列为"name"
    String aa;

    @Column(name="bb")
    String bb;

    @Column(name="cc")
    String cc;


    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public String getBb() {
        return bb;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    @Override
    public String toString() {
        return "Djsaa{" +
                "aa='" + aa + '\'' +
                ", bb='" + bb + '\'' +
                ", cc='" + cc + '\'' +
                '}';
    }
}
