package com.iotpack.api.gateway.ctwing.controller;

import com.iotpack.api.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ctwing")
@Slf4j
public class CtwingController extends BaseController {

    @RequestMapping(value = "/receive",method = RequestMethod.POST)
    @ResponseBody
    public String receive(@RequestBody String body)  {
        System.out.println("推送数据");
        return "ok";
    }

}


