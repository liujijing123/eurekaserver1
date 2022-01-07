package com.liujijing.service;

import com.liujijing.entity.UserBean;

import java.util.List;

public interface UserService {
    List<UserBean> getAll();

    UserBean getById(Integer id);

    List<UserBean> getUserByIdAndAge(Object o, String userName);
}
