package com.yy.mpop.product;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yy.mpop.product.dao.CategoryDao;
import com.yy.mpop.product.entity.BrandEntity;
import com.yy.mpop.product.entity.CategoryEntity;
import com.yy.mpop.product.service.BrandService;
import com.yy.mpop.product.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @description:
 * @author: yy
 * @date: 2020/12/13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {

    @Autowired
    BrandService brandService;

    @Test
    public void testProduct(){

        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("HuaWei");

        brandService.save(brandEntity);
    }

    @Autowired
    private CategoryService categoryService;


    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void removeCateByIds() {
        ArrayList<Long> longs = new ArrayList<>();
        longs.add(1433L);
        categoryService.removeCateByIds(longs);
    }


    @Autowired
    private CategoryDao categoryDao;

    @Test
    public void testCategory() throws JsonProcessingException {
        List<CategoryEntity> categoryEntities = categoryDao.selectList(null);
        System.out.println(objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(categoryEntities));
    }
}
