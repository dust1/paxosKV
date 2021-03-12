package com.dust.kv.conf;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 服务端配置文件对象
 */
@Getter
@Setter
public class ServerConfig {
    
    private int port;
    private String host;
    private String uuid;
    private List<MasterInfo> others;

}
