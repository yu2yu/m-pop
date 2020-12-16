package com.yy.mpop.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yy.mpop.common.utils.PageUtils;
import com.yy.mpop.common.utils.Query;

import com.yy.mpop.product.dao.CategoryDao;
import com.yy.mpop.product.entity.CategoryEntity;
import com.yy.mpop.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> queryCategoryTree(Long parentId) {

        // 先查出一级机构
        QueryWrapper<CategoryEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_cid",parentId);
        List<CategoryEntity> categoryEntities = baseMapper.selectList(wrapper);

        // 再foreach
        return categoryEntities;
    }
}