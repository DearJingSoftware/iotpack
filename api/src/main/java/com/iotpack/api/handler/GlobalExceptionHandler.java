package com.iotpack.api.handler;

import com.iotpack.api.dto.ResDto;
import com.iotpack.api.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResDto handlerBusinessException(BusinessException ex) {
        ResDto res= new ResDto();
        res.setCode(ex.getCode());
        res.setMsg( ex.getMessage());
        res.setData(ex.getData());
        return res;
    }

    @ExceptionHandler(value = java.lang.Exception.class)
    @ResponseBody
    public ResDto exceptionGet(java.lang.Exception e) {
        e.printStackTrace();
        ResDto res= new ResDto();
        res.setCode(-1000);
        res.setMsg("");
        res.setData("");
        return res;
    }
}
