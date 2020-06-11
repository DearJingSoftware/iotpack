package com.iotpack.gateway.coap;

import junit.framework.TestCase;

public class IotPackCoapServerBootstrapTest extends TestCase {

    public void testStart() {
        IotPackCoapServerBootstrap iotPackCoapServerBootstrap=new IotPackCoapServerBootstrap();
        iotPackCoapServerBootstrap.start();
        iotPackCoapServerBootstrap.stop();
    }



    public void testReload() {
        IotPackCoapServerBootstrap iotPackCoapServerBootstrap=new IotPackCoapServerBootstrap();
        iotPackCoapServerBootstrap.start();
        iotPackCoapServerBootstrap.reload();
        iotPackCoapServerBootstrap.stop();
    }
}