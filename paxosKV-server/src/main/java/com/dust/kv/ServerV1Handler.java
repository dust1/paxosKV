package com.dust.kv;

import com.dust.kv.conf.ServerConfig;
import com.dust.kv.core.KVServerHandler;
import com.dust.paxos.Paxos;

import io.vertx.core.AsyncResult;
import io.vertx.core.net.NetSocket;
import lombok.extern.slf4j.Slf4j;

/**
 * 默认的连接处理器
 */
@Slf4j
public class ServerV1Handler implements ServerHandler {

    /**
     * 总体配置
     */
    private ServerConfig serverConfig;
    private Paxos paxos;
    private KVServerHandler handler;

    public ServerV1Handler(ServerConfig serverConfig) {
        this.serverConfig = serverConfig;
        this.paxos = new Paxos(serverConfig.tPaxosConfiguration());
        this.handler = new KVServerHandler(paxos);
    }

    @Override
    public void handler(NetSocket socket) {
        //当一个新的连接进入的时候要执行什么呢？
        
        // socket.handler(arg0)
    }

    @Override
    public void exceptionHandler(Throwable throwable) {
        ServerV1Handler.log.error("Net Connect error, Server was down.");
        throwable.getCause().printStackTrace();
    }

    @Override
    public void closeHandler(AsyncResult<Void> v) {
        //当连接断开后会发生什么？
        ServerV1Handler.log.info("Server was closed");
    }
    
}
