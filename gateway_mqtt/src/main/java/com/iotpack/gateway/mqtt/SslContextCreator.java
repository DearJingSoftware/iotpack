package com.iotpack.gateway.mqtt;

import io.moquette.broker.ISslContextCreator;
import io.netty.handler.ssl.SslContext;

public class SslContextCreator implements ISslContextCreator {
    @Override
    public SslContext initSSLContext() {
        return null;
    }
}
