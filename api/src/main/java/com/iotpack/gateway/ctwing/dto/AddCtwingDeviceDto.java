package com.iotpack.gateway.ctwing.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class AddCtwingDeviceDto {
    String deviceName;
    String deviceSn;
    String imei;
    String operator;
    Map<String,Object> other=new HashMap<>();
    Long productId;
}
