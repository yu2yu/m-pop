package com.yy.mpop.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public List<CategoryEntity> queryCategoryTree() {

        // 先查出一级机构
//        QueryWrapper<CategoryEntity> wrapper = new QueryWrapper<>();
//        wrapper.eq("parent_cid",parentId);
//        List<CategoryEntity> categoryEntities = baseMapper.selectList(wrapper);

        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);
        // 将子节点放进childrenNodes里面
        List<CategoryEntity> parentCategories =
                categoryEntities.stream()
                        // 筛选出来 父节点为 0的节点
                        .filter((k) -> k.getParentCid() == 0)
                        // 并且找出其子节点
                        .map(k -> {
                            k.setChildrenNodes(findChildren(categoryEntities,k.getCatId()));
                            return k;
                        })
                        .collect(Collectors.toList());

        return parentCategories;
    }


    private List<CategoryEntity> findChildren(List<CategoryEntity> categoryEntities,long parentId){

        return categoryEntities.stream().filter(k->k.getParentCid() == parentId)
                .map(k -> {
                    k.setChildrenNodes(findChildren(categoryEntities,k.getCatId()));
                    return k;
                }).collect(Collectors.toList());

    }
}