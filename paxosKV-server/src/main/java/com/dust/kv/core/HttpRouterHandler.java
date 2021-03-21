package com.dust.kv.core;

import io.vertx.ext.web.RoutingContext;

public interface HttpRouterHandler {

    void appendToken(RoutingContext context);

}
