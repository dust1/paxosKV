package com.dust.paxos.core.impl;

import com.dust.paxos.Paxos;
import com.dust.paxos.core.Acceptor;
import com.dust.paxos.entity.AcceptReq;
import com.dust.paxos.entity.AcceptRes;
import com.dust.paxos.entity.PrepareReq;
import com.dust.paxos.entity.PrepareRes;
import com.dust.paxos.entity.ReadReq;
import com.dust.paxos.entity.ReadRes;

/**
 * 存储端的实现
 */
public class DAcceptor implements Acceptor {

    private Paxos paxos;

    public DAcceptor(Paxos paxos) {
        this.paxos = paxos;
    }

    @Override
    public PrepareRes prepare(PrepareReq prepareReq) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AcceptRes accept(AcceptReq acceptReq) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ReadRes read(ReadReq readReq) {
        // TODO Auto-generated method stub
        return null;
    }


}
