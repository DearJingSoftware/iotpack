package com.iotpack.protocol;


public interface ProtocolHandler {
    /**
     * 对设备进行操作
     *
     * @param ctx
     * @return
     */
    default Object action(Object ctx) throws Exception {
        return null;
    }

    ;

    /**
     * 解析协议
     * @param ctx
     * @return
     * @throws Exception
     */
    default Object react(Object ctx) throws Exception {
        return null;
    }
}
