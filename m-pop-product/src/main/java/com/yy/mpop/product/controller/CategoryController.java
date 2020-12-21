package com.yy.mpop.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.yy.mpop.common.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yy.mpop.product.entity.CategoryEntity;
import com.yy.mpop.product.service.CategoryService;
import com.yy.mpop.common.utils.PageUtils;
import com.yy.mpop.common.utils.R;



/**
 * 商品三级分类
 *
 * @author yy
 * @email youny1118@gmail.com
 * @date 2020-12-12 23:05:33
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping(value = "/list/tree/{parentId}",method = RequestMethod.GET)
    public CommonResult<List<? extends CategoryEntity>> getCategoriesByParentId(@PathVariable("parentId") Long parentId,
                                                        @RequestParam(value = "name") String name,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        List<CategoryEntity> categoryEntities = categoryService.queryCategoryTree(parentId,name,pageSize,pageNum);
        return CommonResult.success(categoryEntities);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public CommonResult<String> delete(@RequestBody Long[] catIds){
		categoryService.removeCateByIds(Arrays.asList(catIds));
        return CommonResult.success("删除成功");
    }

}
