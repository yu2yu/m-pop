package com.yy.mpop.product;

import com.yy.mpop.product.entity.BrandEntity;
import com.yy.mpop.product.service.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}
