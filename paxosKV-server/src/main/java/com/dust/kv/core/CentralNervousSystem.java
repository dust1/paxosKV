package com.dust.kv.core;

import java.util.Objects;
import java.util.Optional;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;

/**
 * 神经中枢
 * 
 * 保存Vertx总线相关信息
 */
public class CentralNervousSystem {
    
    private static Vertx vertx;

    /**
     * Vertx初始化
     * @param v
     */
    public static void init(Vertx v) {
        //只会初始化赋值一次
        if (Objects.isNull(vertx)) {
            synchronized (CentralNervousSystem.class) {
                if (Objects.isNull(vertx)) {
                    vertx = v;
                }
            }
        }
    }

    public static Optional<Vertx> getVertx() {
        return Optional.ofNullable(vertx);
    }

    public static Optional<EventBus> getEventBus() {
        if (Objects.isNull(vertx)) {
            return Optional.empty();
        }
        return Optional.of(vertx.eventBus());
    }

}
