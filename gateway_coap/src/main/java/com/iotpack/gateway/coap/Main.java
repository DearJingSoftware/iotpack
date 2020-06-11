package com.iotpack.gateway.coap;

import java.io.IOException;


public class Main {


    public static  void main(String[] argv) throws IOException {

        IotPackCoapServerBootstrap iotPackCoapServerBootstrap=new IotPackCoapServerBootstrap();

        iotPackCoapServerBootstrap.start();

//        server.add(new FibonacciResource("fibonacci"));
//        server.add(new StorageResource("storage"));
//        server.add(new ImageResource("image"));
//        server.add(new MirrorResource("mirror"));
//        server.add(new LargeResource("large"));

    }
}
