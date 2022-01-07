package com.liujijing.controller;

import com.liujijing.entity.UserBean;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 本类作者：刘计静
 * 创建时间：2022/1/3 16:16
 * 本类作用：xxx
 */
@RequestMapping("/consumer/user")
@RestController
@DefaultProperties(defaultFallback = "queryUserByIdFallBack") // 指定一个类的全局熔断方法
public class UserController {

    @Autowired
    private RestTemplate restTemplate;
//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    @RequestMapping("getAll")
//    public Object getAll(){
//        Object forObject = this.restTemplate.getForObject("http://localhost:8082/user/getAll", Object.class);
//        return forObject;
//    }

    @RequestMapping("getById")
    public Object getById(@RequestParam("id") Integer id){
        Object user = this.restTemplate.getForObject("http://localhost:8081/user/getById/" + id, Object.class);
        return user;
    }


    @GetMapping("{id}")
    @HystrixCommand
    public String queryUserById(@PathVariable("id") Long id){
        if(id == 1){
            throw new RuntimeException("太忙了");
        }
      try {
          String url = "http://serviceprovider/user/getById/" + id;
          UserBean user =restTemplate.getForObject(url, UserBean.class);
          return user.toString();
      }catch (Exception e){
          e.printStackTrace();
          return null;
      }
    }
    public String queryUserByIdFallBack(){
        return "请求繁忙，请稍后再试！";
    }
}
