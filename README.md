# paxosKV
采用一致性哈希算法计算Key所在的node，每个node有一个全局唯一的id用于标识，同时这个id也作为paxos的groupID，通过paxos在主备服务器之间进行同步数据。

KV存储的数据类型：int、string、list、set、map。

客户端整合的是SDK，因此客户端与服务端要分开，但是Paxos相关的是整合在服务端的。

paxos组件应该是作为通信与同步相关的组件，而KV负责提供心跳检测、容错、分配token等操作。

为了减少程序占用，paxos组件与KV组件应该共用网络服务。

也就是说网络服务相关部分也需要独立成一个组件，并且可以嵌入到KV与paxos相关逻辑当中。

KV存储节点与其所有数据备份之间组成一个paxos集群。

通信方面通过vertx来构建。将各部分逻辑分割成一个个handler来单独处理。组件之间通过eventBus来通信，而不是直接调用函数方法。