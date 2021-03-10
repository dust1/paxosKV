package com.dust;

import com.dust.kv.KVServer;

import io.vertx.core.AbstractVerticle;

public class PaxosKVMainVerticle extends AbstractVerticle {
    
    @Override
    public void start() {
        // vertx.deployVerticle(KVServer.class.getName());
        // System.out.println("start...");
        vertx.fileSystem().readFile("./conf/setting.json", res -> {
            System.out.println(res.toString());
        });
    }

}
