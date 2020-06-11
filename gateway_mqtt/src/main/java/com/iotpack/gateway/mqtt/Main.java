package com.iotpack.gateway.mqtt;

import com.iotpack.gateway.bootstrap.GatewayBootStrap;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static  void main(String[] argv) {
        GatewayBootStrap gatewayBootStrap=new IotPackMqttBrokerBootstrap();
        gatewayBootStrap.start();
    }
}
