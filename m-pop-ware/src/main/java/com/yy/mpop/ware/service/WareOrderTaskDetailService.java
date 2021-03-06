package com.yy.mpop.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.mpop.common.utils.PageUtils;
import com.yy.mpop.ware.entity.WareOrderTaskDetailEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author yy
 * @email youny1118@gmail.com
 * @date 2020-12-13 10:04:41
 */
public interface WareOrderTaskDetailService extends IService<WareOrderTaskDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

