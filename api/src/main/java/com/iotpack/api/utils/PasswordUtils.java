package com.iotpack.api.utils;

import org.springframework.util.DigestUtils;

public class PasswordUtils {
    public static String getMd5(String password){
        String md5 = DigestUtils.md5DigestAsHex(password.getBytes());
        return md5;
    }
}
