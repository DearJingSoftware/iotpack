package com.iotpack.api.gateway.onenet.service;

import cmcc.iot.onenet.javasdk.api.device.AddDevicesApi;
import cmcc.iot.onenet.javasdk.api.device.DeleteDeviceApi;
import cmcc.iot.onenet.javasdk.model.Location;
import cmcc.iot.onenet.javasdk.response.device.NewDeviceResponse;
import com.iotpack.api.entity.device.DeviceEntity;
import com.iotpack.api.exception.BusinessException;
import com.iotpack.api.service.impl.PlatformGatewayImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class OneNetServiceImpl extends PlatformGatewayImpl {

    @Value("${app.onenet.MasterKey}")
    String key;


    @Override
    public void createDevice(DeviceEntity device)  {
        log.info("onenet 创建设备");
        String title = device.getIMEI();
        String desc = device.getIMEI();
        //设备位置{"纬度", "经度", "高度"}（可选）
        Location location = new Location(0.0, 0.0, 0.0);
        List<String> tags = new ArrayList<String>();
        tags.add("china");
        tags.add("mobile");
        Map<String, String> authinfo = new HashMap<>(1);
        authinfo.put(device.getIMEI(), device.getIMEI());

        try {
            NewDeviceResponse newDeviceResponse=new AddDevicesApi(
                    title,
                    device.getProtocol(),
                    desc,
                    tags,
                    location,
                    true,
                    authinfo,
                    null,
                    null,
                    key)
                    .executeApi()
                    .data;
            System.out.println(newDeviceResponse);
            System.out.println(newDeviceResponse.getDeviceId());
            device.setDeviceId(newDeviceResponse.getDeviceId());
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException("Onenet 创建设备失败");
        }
    }

    @Override
    public void removeDevice(DeviceEntity newEntity)  {
        log.info("onenet 删除设备");
        try {
            new DeleteDeviceApi(newEntity.getDeviceId(), key).executeApi();
        }catch (Exception e){
            throw new BusinessException("Onenet 删除设备失败");
        }

    }
}
