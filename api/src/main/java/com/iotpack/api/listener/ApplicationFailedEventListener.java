package com.iotpack.api.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApplicationFailedEventListener implements ApplicationListener<ApplicationFailedEvent> {


    @Override
    public void onApplicationEvent(ApplicationFailedEvent applicationFailedEvent) {
        log.info("系统启动失败");
    }
}
