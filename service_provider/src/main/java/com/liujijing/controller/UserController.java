package com.liujijing.controller;

import com.liujijing.entity.UserBean;
import com.liujijing.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 本类作者：刘计静
 * 创建时间：2022/1/3 16:08
 * 本类作用：xxx
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("getAll")
    public List<UserBean> getAll(){
        return userService.getAll();
    }
    /**
     * 这是restful的写法
     * 把参数，传到路径后面，然后再参数前面加一个注解PathVariable
     * user/getUserById/2
     */
    @GetMapping("/getById/{id}")
    public UserBean getById(@PathVariable("id") Integer id){
        return userService.getById(id);
    }


        @GetMapping("/getByIdAndAge/{userName}")
    public List<UserBean> queryByIdAndAge(@PathVariable("userName")String userName) {
        return userService.getUserByIdAndAge(null,userName);
    }

}
