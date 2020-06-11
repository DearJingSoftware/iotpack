package com.iotpack.api.gateway.oc.controller;

import com.iotpack.api.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 获取http推送
 */
@RestController
@RequestMapping("/oc")
@Slf4j
public class OcController extends BaseController {

    @RequestMapping(value = "/receive",method = RequestMethod.POST)
    @ResponseBody
    public String receive(@RequestBody String body)  {
        System.out.println("推送数据");
        return "ok";
    }

}


