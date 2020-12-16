package com.yy.mpop.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.mpop.common.utils.PageUtils;
import com.yy.mpop.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author yy
 * @email youny1118@gmail.com
 * @date 2020-12-12 23:05:33
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查询分类树形结构
     * @param parentId
     * @return
     */
    List<CategoryEntity> queryCategoryTree(Long parentId);
}

