package com.dust.paxos.core;


/**
 * 存储端
 */
public interface Acceptor {

    String prepare();

    String accept();

    String get();

}
