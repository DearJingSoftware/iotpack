package com.iotpack.gateway.mqtt;

import io.moquette.broker.security.IAuthorizatorPolicy;
import io.moquette.broker.subscriptions.Topic;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthorizatorPolicy implements IAuthorizatorPolicy {
    @Override
    public boolean canWrite(Topic topic, String username, String clientId) {
        log.info("canWrite topic {} username {} clientId {}",topic,username,clientId);
        return true;
    }

    @Override
    public boolean canRead(Topic topic, String username, String clientId) {
        log.info("canRead topic {} username {} clientId {}",topic,username,clientId);
        return true;
    }
}
