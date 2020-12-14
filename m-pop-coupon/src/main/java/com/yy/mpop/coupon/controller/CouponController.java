package com.yy.mpop.coupon.controller;
import java.math.BigDecimal;
import java.util.Date;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yy.mpop.coupon.entity.CouponEntity;
import com.yy.mpop.coupon.service.CouponService;
import com.yy.mpop.common.utils.PageUtils;
import com.yy.mpop.common.utils.R;



/**
 * 优惠券信息
 *
 * @author yy
 * @email youny1118@gmail.com
 * @date 2020-12-13 10:14:39
 */
@RefreshScope
@RestController
@RequestMapping("coupon/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @Value("${coupon.user.name}")
    String name;
    @Value("${coupon.user.age}")
    int age;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public R getAgeAndName(){
        return R.ok().put("name",name).put("age",age);
    }

    @RequestMapping(value = "/member",method = RequestMethod.GET)
    public R listCouponByMember(){

        CouponEntity coupon = new CouponEntity();
        coupon.setCouponType(0);
        coupon.setCouponImg("");
        coupon.setCouponName("300-40");
        coupon.setNum(0);
        coupon.setAmount(new BigDecimal("0"));
        coupon.setPerLimit(0);
        coupon.setMinPoint(new BigDecimal("0"));
        coupon.setStartTime(new Date());
        coupon.setEndTime(new Date());
        coupon.setUseType(0);
        coupon.setNote("");
        coupon.setPublishCount(0);
        coupon.setUseCount(0);
        coupon.setReceiveCount(0);
        coupon.setEnableStartTime(new Date());
        coupon.setEnableEndTime(new Date());
        coupon.setCode("");
        coupon.setMemberLevel(0);
        coupon.setPublish(0);
        return R.ok().put("coupon", coupon);
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = couponService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		CouponEntity coupon = couponService.getById(id);

        return R.ok().put("coupon", coupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CouponEntity coupon){
		couponService.save(coupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CouponEntity coupon){
		couponService.updateById(coupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		couponService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
