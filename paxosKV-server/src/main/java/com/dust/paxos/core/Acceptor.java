package com.dust.paxos.core;

import com.dust.paxos.entity.AcceptReq;
import com.dust.paxos.entity.AcceptRes;
import com.dust.paxos.entity.PrepareReq;
import com.dust.paxos.entity.PrepareRes;
import com.dust.paxos.entity.ReadReq;
import com.dust.paxos.entity.ReadRes;

/**
 * 存储端
 */
public interface Acceptor {

    /**
     * 写前读取
     * @param prepareReq
     * @return
     */
    PrepareRes prepare(PrepareReq prepareReq);

    /**
     * 写入提交
     * @param acceptReq
     * @return
     */
    AcceptRes accept(AcceptReq acceptReq);

    /**
     * 普通读取
     * @param readReq
     * @return
     */
    ReadRes read(ReadReq readReq);

}
