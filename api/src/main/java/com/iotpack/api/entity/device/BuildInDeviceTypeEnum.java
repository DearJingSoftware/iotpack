package com.iotpack.api.entity.device;

import lombok.Getter;

/**
 * 内建iot设备
 */
@Getter
public enum BuildInDeviceTypeEnum {

    SMOKE_SENSOR(1,"烟感传感器"),

    GAS_SENSOR(2,"燃气传感器"),

    MANUAL_ALARM(3,"手动报警传感器"),

    GATE_SENSOR(4,"门磁传感器"),

    TEMPERATURE_SENSOR(5,"温度传感器"),

    HUMIDITY_SENSOR(6,"湿度传感器"),

    CAMERA(7,"摄像头"),

    ;

    BuildInDeviceTypeEnum(Integer code, String type) {
        this.code = code;
        this.type = type;
    }

    private Integer code;
    private String type;
}
