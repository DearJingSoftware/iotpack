package com.iotpack.api.service;

import com.iotpack.api.entity.device.DeviceEntity;

public interface PlatformGateway {

   void createDevice(DeviceEntity device);
   void removeDevice(DeviceEntity device);
}
