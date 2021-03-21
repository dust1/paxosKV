package com.dust;

import com.dust.kv.HttpHandler;
import com.dust.kv.KVServer;
import com.dust.kv.conf.ServerConfig;
import com.dust.kv.core.CentralNervousSystem;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;

public class KVServerTest {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        CentralNervousSystem.init(vertx);
        ServerConfig serverConfig = getConfig();

        HttpServer server = vertx.createHttpServer();
        Router router = Router.router(vertx);
        HttpHandler httpHandler = HttpHandler.create(serverConfig);
        setRouter(router, httpHandler);

        /*
         * 几个主要的处理器
         */
        server.exceptionHandler(httpHandler::exceptionHandler);
        server.close(httpHandler::closeHandler);

        server.requestHandler(router::accept).listen(serverConfig.getPort(), serverConfig.getHost(), serverRes -> {
            if (serverRes.succeeded()) {
                System.out.println("ok");
            } else {
                System.out.println("fail");
                serverRes.cause().printStackTrace();
            }
        });
    }

    private static ServerConfig getConfig() {
        ServerConfig config = new ServerConfig();
        config.setHost("0.0.0.0");
        config.setPort(8888);
        config.setUuid("sss");
        return config;
    }

    private static void setRouter(Router router, HttpHandler httpHandler) {
        //中心节点你给存储端追加token
        router.route(HttpMethod.POST, "/sys/appendToken").handler(httpHandler.handler()::appendToken);
        router.route(HttpMethod.GET, "/").handler(context -> {
            context.response().putHeader("content-type", "text/plain");
            context.response().end("sss");
        });

    }

}
