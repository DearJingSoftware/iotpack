package com.iotpack.gateway.coap.resource;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

@Slf4j
public class DeviceResource extends CoapResource {

    public DeviceResource(String name) {
        super(name);
    }

    @SneakyThrows
    @Override
    public void handleGET(CoapExchange exchange) {
        log.info("收到GET 请求");
        exchange.respond("test get request");



    }

    @SneakyThrows
    @Override
    public void handlePOST(CoapExchange exchange) {
        log.info("收到POST 请求");
        exchange.respond("test post request");

        exchange.respond("222");
    }

}

