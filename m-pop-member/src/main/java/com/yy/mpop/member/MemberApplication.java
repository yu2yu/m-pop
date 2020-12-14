package com.yy.mpop.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @version 1.0
 * @description:
 * @author: yy
 * @date: 2020/12/13
 */
@SpringBootApplication()
@EnableFeignClients
@MapperScan("com.yy.mpop.member.dao")
public class MemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class, args);
    }
}
