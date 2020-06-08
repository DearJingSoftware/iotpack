package com.iotpack.gateway.coap;

import com.iotpack.gateway.coap.resource.HelloWorldResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;

import java.io.IOException;


public class Main {


    public static  void main(String[] argv) throws IOException {


        CoapServer server = new CoapServer();

        server.add(new HelloWorldResource("hello"));
//        server.add(new FibonacciResource("fibonacci"));
//        server.add(new StorageResource("storage"));
//        server.add(new ImageResource("image"));
//        server.add(new MirrorResource("mirror"));
//        server.add(new LargeResource("large"));

        server.start();
    }
}
