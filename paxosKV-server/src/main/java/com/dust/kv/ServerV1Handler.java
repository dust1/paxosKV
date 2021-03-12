package com.dust.kv;

import com.dust.kv.conf.ServerConfig;

import io.vertx.core.AsyncResult;
import io.vertx.core.net.NetSocket;

/**
 * 
 */
public class ServerV1Handler implements ServerHandler {

    public ServerV1Handler(ServerConfig serverConfig) {
        
    }

    @Override
    public void handler(NetSocket socket) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void exceptionHandler(Throwable throwable) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void closeHandler(AsyncResult<Void> v) {
        // TODO Auto-generated method stub
        
    }
    
}
