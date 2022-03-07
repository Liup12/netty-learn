package com.winchance.netty.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

import java.nio.charset.Charset;

/**
 * @author xuande (xuande@dajiaok.com)
 * @date 2022/3/7  17:12:55
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        // 基于换行符号
        socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));

        // 解码转String，注意调整自己的编码格式GBK、UTF-8
        socketChannel.pipeline().addLast(new StringDecoder(Charset.forName("GBK")));

        socketChannel.pipeline().addLast(new MyServerHandler());
    }
}
