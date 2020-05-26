package com.iotpack.api.enums;

import lombok.Getter;

@Getter
public enum ExceptionEnum implements IExceptionEnum{
    /*未知异常*/
    SYSTEM_ERROR(-1,"未知异常"),
    /*参数不正确*/
    PARAM_ERROR(50000,"参数不正确"),
    /*session失败*/
    SESSION_ERROR_USER(40000,"session获取用户失败"),
    SESSION_ERROR_USER_JSON(40001,"session解析用户失败"),
    SESSION_ERROR_UNKNOWN_USER(40002,"token找不到对应的用户信息"),
    /*页面不存在容错处理*/
    PAGE_NOT_FOUND(404,"api not found");

    ExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;
}
