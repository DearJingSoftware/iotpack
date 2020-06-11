package com.iotpack.gateway.mqtt;

import com.iotpack.gateway.bootstrap.GatewayBootStrap;
import com.iotpack.gateway.mqtt.listener.PublisherListener;
import io.moquette.broker.Server;
import io.moquette.broker.config.ClasspathResourceLoader;
import io.moquette.broker.config.IConfig;
import io.moquette.broker.config.IResourceLoader;
import io.moquette.broker.config.ResourceLoaderConfig;
import io.moquette.interception.InterceptHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;


@Slf4j
public class IotPackMqttBrokerBootstrap implements GatewayBootStrap {

    private final Server mqttBroker = new Server();


    @Override
    public void start() {
        List<? extends InterceptHandler> userHandlers = Collections.singletonList(new PublisherListener());
        IResourceLoader classpathLoader = new ClasspathResourceLoader();
        final IConfig classPathConfig = new ResourceLoaderConfig(classpathLoader);
        mqttBroker.startServer(classPathConfig, userHandlers,new SslContextCreator(), new Authenticator(), new AuthorizatorPolicy());
    }

    @Override
    public void stop() {
        mqttBroker.stopServer();
    }

    @Override
    public void reload() {
        try {
            mqttBroker.stopServer();
        }catch (Exception e){
            log.info("=================== 关闭服务器异常 ===================");
            e.printStackTrace();
        }
        try {
            start();
        }catch (Exception e){
            log.info("=================== 启动服务器异常 ===================");
            e.printStackTrace();
        }


    }
}
