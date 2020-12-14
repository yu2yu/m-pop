package com.yy.mpop.member.openfeign;

import com.yy.mpop.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @version 1.0
 * @description: coupon远程服务调用
 * @author: yy
 * @date: 2020/12/14
 */
@Component
@FeignClient(value = "m-pop-coupon")
public interface CouponService {

    @GetMapping(value = "/coupon/coupon/member")
    R listCouponByMember();
}
