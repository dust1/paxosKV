package com.dust.kv.message;

/**
 * 消息配置参数
 * 用作配置消息相关长度信息
 */
public final class MessageOption {

    /**
     * 请求头部校验信息，解析后为：paxosKV
     */
    public static final byte[] HEAD = {112, 97, 120, 111, 115, 75, 86};

}
