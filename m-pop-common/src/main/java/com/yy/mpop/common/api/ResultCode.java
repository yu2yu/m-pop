package com.yy.mpop.common.api;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @version 1.0
 * @description: 状态码
 * @author: yy
 * @date: 2020/12/16
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ResultCode implements IErrorCode{

    SUCCESS(0000, "操作成功"),

    FAILED(5000, "操作失败"),

    VALIDATE_FAILED(4004, "参数检验失败"),
    UNAUTHORIZED(4001, "暂未登录或token已经过期"),
    FORBIDDEN(4003, "没有相关权限");


    private long code;
    private String message;

}
