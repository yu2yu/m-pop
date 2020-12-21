package com.yy.mpop.product.service.impl;

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
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

//    @Override
//    public List<CategoryEntity> queryCategoryTree(Long parentId) {
//        QueryWrapper<CategoryEntity> wrapper = new QueryWrapper<>();
//        wrapper.eq("parent_cid",parentId);
//        return baseMapper.selectList(wrapper);
//    }

    @Override
    public List<CategoryEntity> queryCategoryTree(Long parentId,String name,Integer pageSize,Integer pageNum) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if(StringUtils.isNotBlank(name)) {
            queryWrapper.eq("name",name);
        }
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);
        return categoryEntities.stream().filter(k->k.getParentCid() == 0)
                .map(k -> {
                    k.setChildrenNodes(findChildren(categoryEntities,k.getCatId()));
                    k.setChild_num(k.getChildrenNodes().size());
                    return k;
                }).collect(Collectors.toList());
    }


    @Override
    public void removeCateByIds(List<Long> catIds) {
        // TODO: 还需要删除其他关联的内容
        this.removeByIds(catIds);
    }

    private List<CategoryEntity> findChildren(List<CategoryEntity> categoryEntities, long parentId){

        return categoryEntities.stream().filter(k->k.getParentCid() == parentId)
                .map(k -> {
                    k.setChildrenNodes(findChildren(categoryEntities,k.getCatId()));
                    k.setChild_num(k.getChildrenNodes().size());
                    return k;
                }).collect(Collectors.toList());

    }
}