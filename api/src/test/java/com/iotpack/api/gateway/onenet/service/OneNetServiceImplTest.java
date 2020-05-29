package com.iotpack.api.gateway.onenet.service;

import org.junit.jupiter.api.Test;
import com.iotpack.api.entity.device.DeviceEntity;

public class OneNetServiceImplTest {


    @Test
    public void createDevice() {
        OneNetServiceImpl oneNetService=new OneNetServiceImpl();
        oneNetService.key="w6jV4MK8QhJnad9MROupeyjHX4A=";
        DeviceEntity deviceEntity=new DeviceEntity();
        deviceEntity.setIMEI("865820031276004");
        oneNetService.createDevice(deviceEntity);
        oneNetService.removeDevice(deviceEntity);
    }
}
