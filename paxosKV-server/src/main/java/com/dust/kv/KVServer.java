package com.dust.kv;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.net.NetServer;

public class KVServer extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        //TODO 这里读取配置并将信息传入网络服务器节点当中
        //TODO 这里应该从配置信息中读取到master节点，并从master节点获取到自身的哈希分布情况
        // IOUtils.
        NetServer server = vertx.createNetServer();
        server.listen(8080, "0.0.0.0", res -> {
            if (res.succeeded()) {
                System.out.println("Server is new listining");
            } else {
                System.out.println("Failed to bind!");
                res.cause().printStackTrace();
            }
        });
    }

}
