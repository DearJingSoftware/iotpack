package com.iotpack.gateway.bootstrap;

public interface GatewayBootStrap {
     default  void init(){};
     void start();
     void stop();
     void reload();
}
