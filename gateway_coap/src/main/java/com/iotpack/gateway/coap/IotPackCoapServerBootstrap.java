package com.iotpack.gateway.coap;

import com.iotpack.gateway.bootstrap.GatewayBootStrap;
import com.iotpack.gateway.coap.resource.HelloWorldResource;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.californium.core.CoapServer;


@Slf4j
public class IotPackCoapServerBootstrap implements GatewayBootStrap {

    private CoapServer server = new CoapServer();

    @Override
    public void start() {
        server.start();
        server.add(new HelloWorldResource("hello"));
    }

    @Override
    public void stop() {
        server.stop();
    }

    @Override
    public void reload() {
        try {
            server.stop();
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
