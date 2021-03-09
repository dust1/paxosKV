package com.dust.paxos.core.impl;

import com.dust.paxos.Paxos;
import com.dust.paxos.core.Proposer;
import com.dust.paxos.entity.GetReq;
import com.dust.paxos.entity.GetRes;
import com.dust.paxos.entity.SetReq;
import com.dust.paxos.entity.SetRes;

/**
 * 客户端的实现
 */
public class DProposer implements Proposer {

    private Paxos paxos;

    public DProposer(Paxos paxos) {
        this.paxos = paxos;
    }

    @Override
    public GetRes get(GetReq getReq) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SetRes set(SetReq setReq) {
        // TODO Auto-generated method stub
        return null;
    }

}
