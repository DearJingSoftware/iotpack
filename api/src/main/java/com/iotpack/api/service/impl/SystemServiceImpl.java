package com.iotpack.api.service.impl;

import com.iotpack.api.service.SystemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SystemServiceImpl implements SystemService {
    @Override
    public void sendMessage(String msg) {
        //TODO 发送提醒消息
    }
}
