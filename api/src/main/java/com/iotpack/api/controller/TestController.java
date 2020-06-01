package com.iotpack.api.controller;

import com.iotpack.api.dto.ResDto;
import com.iotpack.driect.Bootstrap;
import io.moquette.broker.Server;
import io.moquette.broker.config.ClasspathResourceLoader;
import io.moquette.broker.config.IConfig;
import io.moquette.broker.config.IResourceLoader;
import io.moquette.broker.config.ResourceLoaderConfig;
import io.moquette.interception.AbstractInterceptHandler;
import io.moquette.interception.InterceptHandler;
import io.moquette.interception.messages.InterceptPublishMessage;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.mqtt.MqttMessageBuilders;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttQoS;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

@RestController
@RequestMapping("/")
@Slf4j
public class TestController extends BaseController {

    int count = 0;

    @RequestMapping("/test")
    public ResDto test(@RequestParam("port") int port) {
        Bootstrap bs = new Bootstrap();
        bs.run("0.0.0.0", port);
        return success("success");
    }

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


    @RequestMapping("/startmqtt")
    public ResDto startMqtt() throws IOException, InterruptedException {
        IResourceLoader classpathLoader = new ClasspathResourceLoader();
        final IConfig classPathConfig = new ResourceLoaderConfig(classpathLoader);

        final Server mqttBroker = new Server();
        List<? extends InterceptHandler> userHandlers = Collections.singletonList(new PublisherListener());
        mqttBroker.startServer(classPathConfig, userHandlers);

        System.out.println("Broker started press [CTRL+C] to stop");
        //Bind  a shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Stopping broker");
            mqttBroker.stopServer();
            System.out.println("Broker stopped");
        }));

//        Thread.sleep(20000);
//        System.out.println("Before self publish");
//        MqttPublishMessage message = MqttMessageBuilders.publish()
//                .topicName("/exit")
//                .retained(true)
////        qos(MqttQoS.AT_MOST_ONCE);
////        qQos(MqttQoS.AT_LEAST_ONCE);
//                .qos(MqttQoS.EXACTLY_ONCE)
//                .payload(Unpooled.copiedBuffer("Hello World!!".getBytes(UTF_8)))
//                .build();
//
//        mqttBroker.internalPublish(message, "INTRLPUB");
//        System.out.println("After self publish");
        return success("success");
    }

}


