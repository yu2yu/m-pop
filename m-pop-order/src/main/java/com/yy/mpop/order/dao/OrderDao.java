package com.yy.mpop.order.dao;

import com.yy.mpop.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author yy
 * @email youny1118@gmail.com
 * @date 2020-12-13 09:58:29
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
