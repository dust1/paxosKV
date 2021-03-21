package com.dust;

import io.vertx.core.buffer.Buffer;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        Buffer buffer = Buffer.buffer().appendString("paxosKV");
        System.out.println(Arrays.toString(buffer.getBytes()));
    }

}
