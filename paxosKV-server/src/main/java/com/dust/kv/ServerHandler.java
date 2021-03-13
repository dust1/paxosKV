package com.dust.kv;

import com.dust.kv.conf.ServerConfig;

import io.vertx.core.AsyncResult;
import io.vertx.core.Vertx;
import io.vertx.core.net.NetSocket;

/**
 * 处理请求的处理器
 */
public interface ServerHandler {

    /**
     * 处理正常网络Socket
     * @param socket
     */
    void handler(NetSocket socket);

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

    static ServerHandler create(ServerConfig serverConfig) {
        return new ServerV1Handler(serverConfig);
    } 

}
