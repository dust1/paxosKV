package com.dust.kv;


import com.dust.kv.conf.ServerConfig;
import com.dust.kv.core.CentralNervousSystem;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import lombok.extern.slf4j.Slf4j;

/**
 * 这里是程序逻辑入口，配置相关的都在这里c
 */
@Slf4j
public class KVServer extends AbstractVerticle {

    @Override
    public void start() {
        vertx.fileSystem().readFile("./conf/setting.json", res -> {
            if (res.succeeded()) {
                CentralNervousSystem.init(vertx);
                ServerConfig serverConfig = Json.decodeValue(res.result(), ServerConfig.class);

                HttpServer server = vertx.createHttpServer();
                Router router = Router.router(vertx);
                HttpHandler httpHandler = HttpHandler.create(serverConfig);
                setRouter(router, httpHandler);

                /*
                 * 几个主要的处理器
                 */
                server.exceptionHandler(httpHandler::exceptionHandler);
                server.close(httpHandler::closeHandler);

                server.requestHandler(router).listen(serverConfig.getPort(), serverConfig.getHost(), serverRes -> {
                    if (serverRes.succeeded()) {
                        //启动完成后将自身信息发送给中心节点
                        log.info("Server is new listening");

                    } else {
                        log.error("Failed to bind!");
                        serverRes.cause().printStackTrace();
                    }
                });
            } else {
                log.error("can't find ./conf/setting.json, please create it");
            }
        });
    }

    private void setRouter(Router router, HttpHandler httpHandler) {
        //中心节点给存储端追加token
        router.route(HttpMethod.POST, "/sys/appendToken").handler(httpHandler.handler()::appendToken);
        //中心节点读取数据
        router.route(HttpMethod.GET, "/kv/get").handler(httpHandler.handler()::get);
        //写前读取
        router.route(HttpMethod.GET, "/kv/prepare").handler(httpHandler.handler()::prepare);
        //确认写入
        router.route(HttpMethod.PUT, "/kv/accept").handler(httpHandler.handler()::accept);
    }

}
