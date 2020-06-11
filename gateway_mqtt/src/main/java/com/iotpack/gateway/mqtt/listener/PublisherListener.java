package com.iotpack.gateway.mqtt.listener;

import io.moquette.interception.AbstractInterceptHandler;
import io.moquette.interception.messages.InterceptPublishMessage;
import io.netty.buffer.ByteBufUtil;
import lombok.extern.slf4j.Slf4j;

import static java.nio.charset.StandardCharsets.UTF_8;

@Slf4j
public class PublisherListener extends AbstractInterceptHandler {

    @Override
    public String getID() {
        return "EmbeddedLauncherPublishListener";
    }

    @Override
    public void onPublish(InterceptPublishMessage msg) {
        final String decodedPayload = new String( ByteBufUtil.getBytes(msg.getPayload()), UTF_8);
        System.out.println("Received on topic: " + msg.getTopicName() + " content: " + decodedPayload);
    }
}