package com.yy.mpop.product;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Test
    public void testCateTree() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<CategoryEntity> categoryEntities = categoryService.queryCategoryTree(1L);
        System.out.println(objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(categoryEntities));
    }

    @Test
    public void removeCateByIds() {
        ArrayList<Long> longs = new ArrayList<>();
        longs.add(1433L);
        categoryService.removeCateByIds(longs);
    }
}
