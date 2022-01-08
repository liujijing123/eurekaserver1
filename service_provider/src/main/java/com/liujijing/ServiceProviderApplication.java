package com.liujijing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.liujijing.mapper"})
@EnableDiscoveryClient
public class ServiceProviderApplication {
    /**
    这是我的远程仓库修改
    */
    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderApplication.class, args);
    }

}
