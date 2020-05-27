package com.iotpack.api.service.impl;

import com.iotpack.api.entity.device.DeviceCheckListEntity;
import com.iotpack.api.entity.device.DeviceCheckListRepository;
import com.iotpack.api.entity.device.DeviceEntity;
import com.iotpack.api.exception.BusinessException;
import com.iotpack.api.service.PlatformGateway;
import com.iotpack.api.service.impl.platformGateway.CtwingGatewayImpl;
import com.iotpack.api.service.impl.platformGateway.DirectGatewayImpl;
import com.iotpack.api.service.impl.platformGateway.OceanConnectGatewayImpl;
import com.iotpack.api.service.impl.platformGateway.OnenetGatewayImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Supplier;

public class PlatformGatewayImpl implements PlatformGateway {

    @Autowired
    OceanConnectGatewayImpl oceanConnectGateway;
    @Autowired
    CtwingGatewayImpl ctwingGateway;
    @Autowired
    OnenetGatewayImpl onenetGateway;
    @Autowired
    DirectGatewayImpl directGateway;

    @Autowired
    DeviceCheckListRepository deviceCheckListRepository;

    @Override
    public void createDevice(DeviceEntity device) {
        getAccessPoint(device).createDevice(device);
    }

    @Override
    public void removeDevice(DeviceEntity device) {
        getAccessPoint(device).removeDevice(device);
    }

    private PlatformGateway getAccessPoint(DeviceEntity device){
        DeviceCheckListEntity deviceCheckListEntity=deviceCheckListRepository.findById(device.getDeviceType()).orElseThrow((Supplier<RuntimeException>) () -> new BusinessException("设备不存在"));
        switch (deviceCheckListEntity.getAccessType()){
            case 1:
                return directGateway;
            case 2:
                break;
            case 3:
                return oceanConnectGateway;
            case 4:
                return  onenetGateway;
            case 5:
                return ctwingGateway;
            default:
                throw  new BusinessException("设备接入方式不存在");
        }
        throw  new BusinessException("设备接入方式不存在");
    }
}
