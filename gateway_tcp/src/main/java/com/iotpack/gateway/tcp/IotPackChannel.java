package com.iotpack.gateway.tcp;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class IotPackChannel extends ChannelInitializer<SocketChannel> {
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        System.out.println("初始化" + socketChannel.remoteAddress().toString());
        ChannelPipeline p = socketChannel.pipeline();
        p.addLast(new LoggingHandler(LogLevel.INFO));
        p.addLast(new DelimiterBasedFrameDecoder(1024, Unpooled.copiedBuffer("\r\n".getBytes())));
//        p.addLast(new JsonObjectDecoder());
        p.addLast(new IotPackInHandler());
    }
}
