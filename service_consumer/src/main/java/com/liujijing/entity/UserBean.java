package com.liujijing.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 本类作者：刘计静
 * 创建时间：2022/1/3 15:58
 * 本类作用：xxx
 */
@Data
public class UserBean implements Serializable {

    private int id;
    private String userName;
    private String passWord;
    private Date userDate;


    public Date getUserDate() {
        return userDate;
    }

    public void setUserDate(Date userDate) {
        this.userDate = userDate;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
