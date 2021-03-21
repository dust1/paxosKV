package com.dust.kv;

import com.dust.kv.conf.ServerConfig;
import com.dust.kv.core.HttpRouterHandler;
import com.dust.kv.core.HttpRouterHandlerImpl;
import com.dust.kv.core.KVServerHandler;
import com.dust.kv.message.MessageHandler;
import com.dust.paxos.Paxos;

import io.netty.handler.codec.http.HttpRequest;
import io.netty.util.internal.MathUtil;
import io.vertx.core.AsyncResult;
import io.vertx.core.MultiMap;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.net.NetSocket;
import lombok.extern.slf4j.Slf4j;

/**
 * 默认的连接处理器
 */
@Slf4j
public class HttpV1Handler implements HttpHandler {

    /**
     * 总体配置
     */
    private ServerConfig serverConfig;
    private Paxos paxos;
    private KVServerHandler handler;
    private MessageHandler messageHandler;

    public HttpV1Handler(ServerConfig serverConfig) {
        this.serverConfig = serverConfig;
        this.paxos = new Paxos(serverConfig.tPaxosConfiguration());
        this.handler = new KVServerHandler(paxos);
        this.messageHandler = new MessageHandler();
    }

    @Override
    public HttpRouterHandler handler() {
        return new HttpRouterHandlerImpl();
    }

    @Override
    public void exceptionHandler(Throwable throwable) {
        log.error("Net Connect error, Server was down.");
        throwable.getCause().printStackTrace();
    }

    @Override
    public void closeHandler(AsyncResult<Void> v) {
        //当连接断开后会发生什么？
        log.info("Server was closed");
    }
    
}
