package com.iotpack.api.enums;

import lombok.Getter;

@Getter
public enum BusinessExceptionEnum implements IExceptionEnum{
    /*未知异常*/
    PAGE_NOT_FOUND(404,"api not found");




    BusinessExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;
}