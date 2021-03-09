package com.dust.paxos.core.impl;

import com.dust.paxos.Paxos;
import com.dust.paxos.core.Learner;

public class DLearner implements Learner {
    
    private Paxos paxos;

    public DLearner(Paxos paxos) {
        this.paxos = paxos;
    }

}
