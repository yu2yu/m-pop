package com.yy.mpop.product.dao;

import com.yy.mpop.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 在对应的Mapper上面继承基本的类 BaseMapper
 * 代表持久层
 * @author yy
 * @email youny1118@gmail.com
 * @date 2020-12-12 23:05:33
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
