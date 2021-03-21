package com.dust.kv;

import java.util.List;
import java.util.Properties;

import com.dust.kv.conf.ServerConfig;
import com.dust.kv.core.CentralNervousSystem;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.NetServerOptions;
import io.vertx.ext.web.Router;
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

                server.listen(serverConfig.getPort(), serverConfig.getHost(), serverRes -> {
                    if (serverRes.succeeded()) {
                        KVServer.log.info("Server is new listening");
                    } else {
                        KVServer.log.error("Failed to bind!");
                        serverRes.cause().printStackTrace();
                    }
                });
            } else {
                KVServer.log.error("can't find ./conf/setting.json, please create it");
            }
        });
    }

    private void setRouter(Router router, HttpHandler httpHandler) {
        //中心节点你给存储端追加token
        router.route(HttpMethod.POST, "/sys/appendToken").handler(httpHandler.handler()::appendToken);

    }

}
