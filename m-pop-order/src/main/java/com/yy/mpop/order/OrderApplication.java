package com.yy.mpop.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @version 1.0
 * @description:
 * @author: yy
 * @date: 2020/12/13
 */
@SpringBootApplication()
@MapperScan("com.yy.mpop.order.dao")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
