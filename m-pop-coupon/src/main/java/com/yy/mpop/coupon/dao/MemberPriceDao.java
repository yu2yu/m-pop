package com.yy.mpop.coupon.dao;

import com.yy.mpop.coupon.entity.MemberPriceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品会员价格
 * 
 * @author yy
 * @email youny1118@gmail.com
 * @date 2020-12-13 10:14:38
 */
@Mapper
public interface MemberPriceDao extends BaseMapper<MemberPriceEntity> {
	
}
