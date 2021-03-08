package com.dust.paxos.conf;

import lombok.Getter;
import lombok.Setter;

/**
 * paxos配置项
 * 有默认配置，同时也可以通过配置文件配置
 */
@Getter
@Setter
public class PaxosConfiguration {

    private int id;
    
    @Override
    public String toString() {
        //TODO 重载toString方法，用于展示配置信息
        return null;
    }

}
