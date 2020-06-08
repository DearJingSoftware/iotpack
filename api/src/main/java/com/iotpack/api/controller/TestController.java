package com.iotpack.api.controller;

import com.iotpack.api.dto.ResDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class TestController extends BaseController {

    int count = 0;

    @RequestMapping("/test1")
    public ResDto test1() {
        return success("success");
    }

    @RequestMapping("/test2")
    public ResDto test2() throws InterruptedException {
        Thread.sleep(5000);
        return success("success");
    }


}


