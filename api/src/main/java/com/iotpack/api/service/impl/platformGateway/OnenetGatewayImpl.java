package com.iotpack.api.service.impl.platformGateway;

import com.iotpack.api.entity.device.DeviceEntity;
import com.iotpack.api.service.PlatformGateway;
import com.iotpack.api.service.impl.PlatformGatewayImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OnenetGatewayImpl extends PlatformGatewayImpl {

    @Value("${app.onenet.key}")
    String key;

    @Override
    public void createDevice(DeviceEntity device) {

    }

    @Override
    public void removeDevice(DeviceEntity device) {


    }
}
