package com.yy.mpop.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.mpop.common.utils.PageUtils;
import com.yy.mpop.coupon.entity.SkuLadderEntity;

import java.util.Map;

/**
 * 商品阶梯价格
 *
 * @author yy
 * @email youny1118@gmail.com
 * @date 2020-12-13 10:14:38
 */
public interface SkuLadderService extends IService<SkuLadderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

