package com.dust.paxos.core;

import com.dust.paxos.entity.GetReq;
import com.dust.paxos.entity.GetRes;
import com.dust.paxos.entity.SetReq;
import com.dust.paxos.entity.SetRes;

/**
 * 客户端
 */
public interface Proposer {

    /**
     * 获取对象
     * @param getReq
     * @return
     */
    GetRes get(GetReq getReq);

    /**
     * 设置对象
     * @param setReq
     * @return
     */
    SetRes set(SetReq setReq);

}
