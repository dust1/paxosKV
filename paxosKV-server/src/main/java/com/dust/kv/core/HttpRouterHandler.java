package com.dust.kv.core;

import io.vertx.ext.web.RoutingContext;

public interface HttpRouterHandler {

    void appendToken(RoutingContext context);

    void get(RoutingContext context);

    void prepare(RoutingContext context);

    void accept(RoutingContext context);
}
