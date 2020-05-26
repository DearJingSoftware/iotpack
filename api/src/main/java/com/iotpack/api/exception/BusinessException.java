package com.iotpack.api.exception;


import com.iotpack.api.enums.IExceptionEnum;
import lombok.Data;

import java.util.HashMap;

@Data
public class BusinessException extends RuntimeException {

    private Integer code;

    private Object data = new HashMap<String, String>(1);


    public BusinessException(String message) {
        super(message);
        this.code = -1;
    }

    public BusinessException(IExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(IExceptionEnum exceptionEnum, Object data) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
        this.data = data;
    }

    public BusinessException(Integer code, String message, Object data) {
        super(message);
        this.code = code;
        this.data = data;
    }
}
