package com.yy.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yy.mpop.common.api.CommonResult;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @version 1.0
 * @description:
 * @author: yy
 * @date: 2020/12/18
 */
public class CommonTest {

    @Test
    public void testCommonResult() {

        ArrayList<String> strings = new ArrayList<>();
        strings.add("dawwad");

        System.out.println(CommonResult.failed("错误").toString());

    }

}
