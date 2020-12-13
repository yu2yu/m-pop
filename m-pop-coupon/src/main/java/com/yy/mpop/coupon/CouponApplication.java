package com.yy.mpop.coupon;

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
@MapperScan("com.yy.mpop.coupon.dao")
public class CouponApplication {
    public static void main(String[] args) {
        SpringApplication.run(CouponApplication.class, args);
    }
}
