package com.yy.mpop.product.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
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
    public PageUtils queryCategoryTree(Long parentId,String name,Integer pageSize,Integer pageNum) {
        QueryWrapper<CategoryEntity> queryWrapper = new QueryWrapper();
        if(StringUtils.isNotBlank(name)) {
            queryWrapper.eq("name",name);
        }
        queryWrapper.eq("parent_cid",parentId);
        Page<CategoryEntity> page = new Page<>(pageNum,pageSize);
        IPage<CategoryEntity> pageInfo = this.page(page,queryWrapper);
        return new PageUtils(pageInfo);
    }


    @Override
    public List<CategoryEntity> queryCategoryAll() {

        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);

        return categoryEntities.stream()
                .filter(k->k.getParentCid() == 0)
                .map(k -> {
                    k.setChildren(findCildren(categoryEntities,k.getCatId()));
                    return k;
                }).collect(Collectors.toList());

    }

    private List<CategoryEntity> findCildren(List<CategoryEntity> categoryEntities, Long parentId) {

        return categoryEntities.stream().filter(k->k.getParentCid() == parentId)
                .map(k -> {
                    k.setChildren(findCildren(categoryEntities,k.getCatId()));
                    return k;
                }).collect(Collectors.toList());

    }

    @Override
    public void removeCateByIds(List<Long> catIds) {
        // TODO: 还需要删除其他关联的内容
        this.removeByIds(catIds);
    }
}