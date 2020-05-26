package com.iotpack.api.controller;

import com.iotpack.api.dto.ResDto;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class BaseController {
    public ResDto success(){
        ResDto ret=new ResDto("");
        ret.setCode(0);
        return ret;
    }
    public ResDto success(Object res){
        ResDto ret=new ResDto(res);
        ret.setCode(0);
        return ret;
    }
}
