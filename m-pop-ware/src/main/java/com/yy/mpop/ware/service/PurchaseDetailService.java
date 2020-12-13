package com.yy.mpop.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.mpop.common.utils.PageUtils;
import com.yy.mpop.ware.entity.PurchaseDetailEntity;

import java.util.Map;

/**
 * 
 *
 * @author yy
 * @email youny1118@gmail.com
 * @date 2020-12-13 10:04:41
 */
public interface PurchaseDetailService extends IService<PurchaseDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

