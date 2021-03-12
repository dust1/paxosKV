package com.dust.kv;

import java.util.List;

import com.dust.kv.conf.ServerConfig;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.NetServer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * 这里是程序逻辑入口，配置相关的都在这里c
 */
@Slf4j
public class KVServer extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        //这里读取配置并将信息传入网络服务器节点当中
        //这里应该从配置信息中读取到master节点，并从master节点获取到自身的哈希分布情况
        vertx.fileSystem().readFile("./conf/setting.json", res -> {
            if (res.succeeded()) {
                ServerConfig serverConfig = Json.decodeValue(res.result(), ServerConfig.class);
                NetServer server = vertx.createNetServer();
                //这里可以修改为工厂设计模式？
                ServerHandler socketHandler = ServerHandler.create(serverConfig);

                /**
                 * 几个主要的处理器
                 */
                server.connectHandler(socketHandler::handler);
                server.exceptionHandler(socketHandler::exceptionHandler);
                server.close(socketHandler::closeHandler);

                server.listen(serverConfig.getPort(), serverConfig.getHost(), serverRes -> {
                    if (serverRes.succeeded()) {
                        System.out.println("Server is new listining");
                    } else {
                        System.out.println("Failed to bind!");
                        serverRes.cause().printStackTrace();
                    }
                });
                
            } else {
                KVServer.log.error("can't find ./conf/setting.json, please create it");
            }
        });
    }

    public static void main(String[] args) {
        String str = "{\"port\":8888,\"host\":\"0.0.0.0\",\"master\":[{\"port\":8888,\"host\":\"168.215.154.21\"},{\"port\":8888,\"host\":\"168.215.154.22\"}],\"uuid\":\"-\"}";
        JsonObject obj = new JsonObject(str);
        Test test = Json.decodeValue(str, Test.class);
        System.out.println(test.toString());
    }

    @Getter
    @Setter
    @ToString
    static class Test {
        private int port;
        private String host;
        private List<TestA> master;
        private String uuid;
    }

    @ToString
    @Getter
    @Setter
    static class TestA {
        private int port;
        private String host;
    }

}
