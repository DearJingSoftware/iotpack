package com.iotpack.api.controller;

import com.iotpack.api.dto.ResDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class IndexController extends BaseController {
    int count = 0;

    @RequestMapping("/ping")
    public ResDto ping() {
        log.info("ping " + count);
        return success("success");
    }
}


