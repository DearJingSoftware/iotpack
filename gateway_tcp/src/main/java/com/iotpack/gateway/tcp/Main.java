package com.iotpack.gateway.tcp;

public class Main {
    public static void main(String[] argv) throws Exception {
        Bootstrap bootstrap=new Bootstrap();
        bootstrap.run("127.0.0.1",28081);
    }
}
