package com.iotpack.api.utils;

public class TokenUtils {
    public static String getToken(){
        SnowFlakeUtils SnowFlakeUtils = new SnowFlakeUtils(1,1,1);
        return String.valueOf(SnowFlakeUtils.nextId());
    }
}
