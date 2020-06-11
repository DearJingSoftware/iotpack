package com.iotpack.gateway.coap.resource;


import lombok.extern.slf4j.Slf4j;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

@Slf4j
public class HelloWorldResource extends CoapResource {

    public HelloWorldResource(String name) {
        super(name);
    }

    @Override
    public void handleGET(CoapExchange exchange) {
        log.info("收到请求");
        exchange.respond("hello world");
    }

}

