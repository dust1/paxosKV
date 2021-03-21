package com.dust.kv.core;

import com.dust.kv.conf.ServerConfig;
import com.dust.kv.core.HttpRouterHandler;
import io.vertx.core.AsyncResult;

/**
 * 处理请求的处理器
 */
public interface HttpHandler {

    /**
     * 返回Http路由处理器
     */
    HttpRouterHandler handler();

    /**
     * 当server链接发生异常的情况
     * @param throwable
     */
    void exceptionHandler(Throwable throwable);

    /**
     * 当server链接断开的情况
     * @param v
     */
    void closeHandler(AsyncResult<Void> v);

    static HttpHandler create(ServerConfig serverConfig) {
        return new HttpV1Handler(serverConfig);
    } 

}
