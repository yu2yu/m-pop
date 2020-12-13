package com.yy.mpop.order.dao;

import com.yy.mpop.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author yy
 * @email youny1118@gmail.com
 * @date 2020-12-13 09:58:28
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
