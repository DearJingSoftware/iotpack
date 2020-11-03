package com.iotpack.gateway;

import com.iotpack.api.entity.device.DeviceEntity;

public interface PlatformGateway {

    /**
     * 启动网关
     */
    default void start() {

    }

    /**
     * 暂停网关
     */
    default void stop() {


    }

    /**
     * 重启网关
     */
    default void reload() {


    }


    /**
     * 执行命令
     *
     * @param device
     */
    default void execCommand(Object device) {

    }

    /**
     * 查询设备
     *
     * @param device
     */
    default void queryDevice(Object device) {

    }

    ;

    /**
     * 创建设备
     *
     * @param device
     */
    default void createDevice(Object device) {

    }

    /**
     * 删除设备
     *
     * @param device
     */
    default void removeDevice(Object device) {

    }

    ;
}
