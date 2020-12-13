package com.yy.mpop.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.mpop.common.utils.PageUtils;
import com.yy.mpop.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author yy
 * @email youny1118@gmail.com
 * @date 2020-12-13 09:58:29
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

