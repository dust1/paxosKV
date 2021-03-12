package com.dust.kv.conf;

import lombok.Getter;
import lombok.Setter;

/**
 * 中心节点网络信息
 */
@Getter
@Setter
public class MasterInfo {
    
    private int port;
    private String host;

}
