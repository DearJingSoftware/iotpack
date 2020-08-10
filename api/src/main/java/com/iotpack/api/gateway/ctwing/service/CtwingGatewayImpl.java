package com.iotpack.api.gateway.ctwing.service;

import com.ctg.ag.sdk.biz.AepDeviceManagementClient;
import com.ctg.ag.sdk.biz.aep_device_management.CreateDeviceRequest;
import com.ctg.ag.sdk.biz.aep_device_management.CreateDeviceResponse;
import com.ctg.ag.sdk.biz.aep_device_management.DeleteDeviceRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iotpack.api.entity.device.DeviceEntity;
import com.iotpack.api.exception.BusinessException;
import com.iotpack.api.gateway.ctwing.dto.AddCtwingDeviceDto;
import com.iotpack.api.gateway.ctwing.dto.AddCtwingDeviceResponseDto;
import com.iotpack.api.gateway.ctwing.dto.ResponseDto;
import com.iotpack.api.service.impl.PlatformGatewayImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

@Service
@Slf4j
public class CtwingGatewayImpl extends PlatformGatewayImpl {

    @Value("${app.ctwing.appKey}")
    String appKey;

    @Value("${app.ctwing.appSecret}")
    String appSecret;

    @Value("${app.ctwing.MasterKey}")
    String masterKey;

    @Value("${app.ctwing.ProductId}")
    Long ProductId;

    @Override
    public void createDevice(DeviceEntity device) {
        log.info("ctwing创建设备请求");
        AepDeviceManagementClient client =
                AepDeviceManagementClient
                        .newClient()
                        .appKey(appKey).appSecret(appSecret)
                        .build();

        CreateDeviceRequest request = new CreateDeviceRequest();
        request.setParamMasterKey(masterKey);
        Gson gson = new Gson();

        AddCtwingDeviceDto addCtwingDeviceDto = new AddCtwingDeviceDto();
        String imei = String.valueOf(device.getMeta().get("imei"));
        addCtwingDeviceDto.setDeviceName(imei);
        addCtwingDeviceDto.setDeviceSn(imei);
        addCtwingDeviceDto.setImei(imei);
        addCtwingDeviceDto.getOther().put("autoObserver", 0);
        addCtwingDeviceDto.setProductId(ProductId);
        request.setBody(gson.toJson(device).getBytes());

        System.out.println(device);
        CreateDeviceResponse createDeviceResponse = null;
        try {
            createDeviceResponse = client.CreateDevice(request);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("Ctwing 创建设备失败");
        }

        Type type = new TypeToken<ResponseDto<AddCtwingDeviceResponseDto>>() {
        }.getType();
        ResponseDto<AddCtwingDeviceResponseDto> res = gson.fromJson(new String(createDeviceResponse.getBody()), type);

        if (!res.getCode().equals(0)) {
            throw new BusinessException(res.getCode(), res.getMsg());
        }

        device.setDeviceId(res.getResult().getDeviceId());
        client.shutdown();
    }

    @Override
    public void removeDevice(DeviceEntity device) {
        AepDeviceManagementClient client = AepDeviceManagementClient.newClient()
                .appKey(appKey).appSecret(appSecret)
                .build();

        DeleteDeviceRequest request = new DeleteDeviceRequest();
        request.setParamMasterKey(masterKey);

        request.setParamProductId(ProductId);
        request.setParamDeviceIds(device.getDeviceId());
        try {
            System.out.println(client.DeleteDevice(request));
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("Ctwing 删除设备失败");
        }
        client.shutdown();
    }
}
