package org.lyh.http.proxy;

import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @author lvyahui (lvyahui8@gmail.com,lvyahui8@126.com)
 * @since 2018/4/14 10:13
 */
public class DefaultProxyRequestFilter implements ProxyRequestFilter {
    @Override
    public FullHttpRequest filter(FullHttpRequest request) {
        return request;
    }
}
