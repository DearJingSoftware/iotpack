package com.iotpack.api.controller;

import com.iotpack.api.dto.ResDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController extends BaseController {

    @RequestMapping("/ping")
    public ResDto ping(){
        return success("success");
    }
}


