package com.iotpack.api.controller;

import com.iotpack.api.dto.ResDto;
import com.iotpack.driect.Bootstrap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class TestController extends BaseController {
    int count=0;
    @RequestMapping("/test")
    public ResDto test(@RequestParam("port") int port){
        Bootstrap bs=new Bootstrap();
        bs.run("0.0.0.0",port);
        return success("success");
    }
}


