package com.iotpack.gateway.mqtt;

import io.moquette.broker.Server;
import io.moquette.broker.config.ClasspathResourceLoader;
import io.moquette.broker.config.IConfig;
import io.moquette.broker.config.IResourceLoader;
import io.moquette.broker.config.ResourceLoaderConfig;
import io.moquette.interception.AbstractInterceptHandler;
import io.moquette.interception.InterceptHandler;
import io.moquette.interception.messages.InterceptPublishMessage;
import io.netty.buffer.ByteBufUtil;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Main {
    static class PublisherListener extends AbstractInterceptHandler {

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

    public static  void main(String[] argv) throws IOException {
            IResourceLoader classpathLoader = new ClasspathResourceLoader();

            final IConfig classPathConfig = new ResourceLoaderConfig(classpathLoader);

            final Server mqttBroker = new Server();

            List<? extends InterceptHandler> userHandlers = Collections.singletonList(new PublisherListener());

            mqttBroker.startServer(classPathConfig, userHandlers);

            System.out.println("Broker started press [CTRL+C] to stop");
//
//            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//                System.out.println("Stopping broker");
//                mqttBroker.stopServer();
//                System.out.println("Broker stopped");
//            }));


    }
}
