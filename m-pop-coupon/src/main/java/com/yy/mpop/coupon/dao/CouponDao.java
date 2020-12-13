package com.yy.mpop.coupon.dao;

import com.yy.mpop.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author yy
 * @email youny1118@gmail.com
 * @date 2020-12-13 10:14:39
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
