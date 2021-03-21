package com.dust.kv.message;


import io.vertx.core.buffer.Buffer;

import java.util.Arrays;

/**
 * 消息处理器
 */
public class MessageHandler {

    public void parse(Buffer buffer) {

    }

    /**
     * 检查头部
     * @param buffer
     * @return
     */
    public boolean checkHeader(Buffer buffer) {
        byte[] head = buffer.getBuffer(0, MessageOption.HEAD.length).getBytes();
        return Arrays.equals(head, MessageOption.HEAD);
    }

}
