# paxosKV
采用一致性哈希算法计算Key所在的node，每个node有一个全局唯一的id用于标识，同时这个id也作为paxos的groupID，通过paxos在主备服务器之间进行同步数据。

KV存储的数据类型：int、string、list、set、map。