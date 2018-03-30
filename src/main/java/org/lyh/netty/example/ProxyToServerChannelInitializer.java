package org.lyh.netty.example;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;

/**
 * 从代理平台到服务端的通道初始化类
 * @author lvyahui (lvyahui8@gmail.com,lvyahui8@126.com)
 * @since 2018/3/27 17:48
 */
public class ProxyToServerChannelInitializer extends ChannelInitializer<SocketChannel> {


    private final ChannelHandlerContext ctx;

    private FullHttpRequest request;

    public ProxyToServerChannelInitializer(ChannelHandlerContext ctx, FullHttpRequest request) {
        this.ctx = ctx;
        this.request = request;
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast("http-codec",new HttpClientCodec());
        ch.pipeline().addLast("http-aggregator",new HttpObjectAggregator(1024 * 1024));
        ch.pipeline().addLast(new ProxyToServerHandler(ctx,request));
    }
}
