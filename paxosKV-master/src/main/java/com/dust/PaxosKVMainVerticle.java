package com.dust;

import com.dust.kv.KVServer;

import io.vertx.core.AbstractVerticle;

/**
 * 这里是系统第一层入口
 * 这里的逻辑用于设置程序进程相关配置，如开启线程数等方面。这里不会读取配置文件
 */
public class PaxosKVMainVerticle extends AbstractVerticle {
    
    @Override
    public void start() {
        vertx.deployVerticle(KVServer.class.getName());
    }

}
