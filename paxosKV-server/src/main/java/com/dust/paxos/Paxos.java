package com.dust.paxos;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.dust.net.PaxosNetNode;
import com.dust.paxos.conf.PaxosConfiguration;
import io.vertx.core.eventbus.EventBus;
import lombok.extern.slf4j.Slf4j;


/**
 * Paxos组件核心
 * 负责对接网络组件与KV组件，同时管理Paxos相关逻辑
 */
@Slf4j
public class Paxos {

    private PaxosConfiguration configuration;

    //消息神经主线
    private EventBus eventBus;

    private static final String PAXOS_START = "paxos.";

    //哈希地址
    private List<String> hashList;
    //目前为止所有位于Paxos中的哈希值
    private Set<String> totalHashSet;

    public Paxos(PaxosConfiguration conf, EventBus eventBus) {
        this.configuration = conf;
        this.eventBus = eventBus;
        this.hashList = new ArrayList<>();
        this.totalHashSet = new HashSet<>();

        Paxos.log.info("Paxos Server created, config info:[" + configuration.toString() + "]");
    }

    /**
     * 给Paxos添加网络节点
     * 这里的添加是动态添加，初始化的时候会初始化所有数据的备份节点信息
     * 但是当某个节点宕机后需要修改网络节点。
     * 否则一致性请求会失败
     * @param node
     */
    public void addNetNode(PaxosNetNode node) {
        Paxos.log.info("Paxos Server addNetNode, node info:[" + node.toString() + "]");
        //TODO 追加网络节点
    }

    /**
     * 批量添加网络节点
     * @param nodes
     */
    public void addNetnodes(List<PaxosNetNode> nodes)  {
        for (PaxosNetNode node : nodes) {
            addNetNode(node);
        }
    }

    /**
     * 移除某个网络节点
     * @param node
     */
    public void removeNetNode(PaxosNetNode node) {
        Paxos.log.warn("Paxos Server removeNetNode, node info:[" + node.toString() + "]");
        //TODO 移除网络节点
    }

    /**
     * 给这个存储节点添加哈希
     * @return
     */
    public boolean appendHash(String hash) {
        if (totalHashSet.contains(hash)) {
            Paxos.log.warn("Paxos Server:" + configuration.getId() + " existing hash : " + hash);
            return false; 
        }
        totalHashSet.add(hash);
        hashList.add(hash);
        return true;
    }

    /**
     * 启动服务，准备接收网络信息
     */
    public void ready() {
        Paxos.log.info("Paxos Server are start ready. id:[" + configuration.getId() + "]");
        
    }

    /**
     * 向网络服务注册信息
     */
    public void registerNetServer() {

    }

}
