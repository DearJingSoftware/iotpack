package com.iotpack.gateway.tcp;

public interface ProtocolBootstrap {

    void run(String bindAddr,int port);

    /**
     * 启动
     */
    void start();

    /**
     * 停止
     */
    void stop();

    /**
     *  重新启动
     */
    void restart();

    /**
     * 启动进度更新
     * @param percent
     * @param msg
     */
    void startProgress(int percent,String msg);

}
