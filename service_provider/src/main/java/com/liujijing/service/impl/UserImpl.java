package com.liujijing.service.impl;

import com.liujijing.entity.UserBean;
import com.liujijing.mapper.UserMapper;
import com.liujijing.service.UserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * 本类作者：刘计静
 * 创建时间：2022/1/3 16:07
 * 本类作用：xxx
 */
@Service
public class UserImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<UserBean> getAll() {
        return userMapper.selectByExample(null);
    }

    @Override
    public UserBean getById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UserBean> getUserByIdAndAge(Object o, String userName) {
        Example example = new Example(UserBean.class);
        Example.Criteria criteria = example.createCriteria();
        if(userName !=null){
            criteria.andEqualTo("userName", userName);
        }
        return userMapper.selectByExample(example);
    }
}
