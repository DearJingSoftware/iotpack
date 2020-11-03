package com.iotpack.gateway.onenet.controller;

import com.iotpack.api.controller.BaseController;
import com.iotpack.gateway.onenet.utils.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/onenet")
@Slf4j
public class OnenetController extends BaseController {

    @Value("${app.onenet.http.token}")
    String token;

    @Value("${app.onenet.http.aes}")
    String aes;

    @RequestMapping(value = "/receive",method = RequestMethod.POST)
    @ResponseBody
    public String receive(@RequestBody String body) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {

        log.info("data receive:  body String --- " +body);
        Util.BodyObj obj = null;
        try {
            obj = Util.resolveBody(body, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        log.info("data receive:  body Object --- " +obj);
        if (obj != null){
            boolean dataRight = Util.checkSignature(obj, token);
            if (dataRight){
                log.info("data receive: content" + obj.toString());
            }else {
                log.info("data receive: signature error");
            }

        }else {
            log.info("data receive: body empty error");
        }
        return "ok";
    }

    @RequestMapping(value = "/receive", method = RequestMethod.GET)
    @ResponseBody
    public String check(@RequestParam(value = "msg") String msg,
                        @RequestParam(value = "nonce") String nonce,
                        @RequestParam(value = "signature") String signature) throws UnsupportedEncodingException {

        log.info("url&token check: msg:{} nonce{} signature:{}",msg,nonce,signature);
        if (Util.checkToken(msg,nonce,signature,token)){
            return msg;
        }else {
            return "error";
        }

    }
}


