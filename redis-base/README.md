# Redis的五种数据类型

## String类型
set 
setnx 
```
setnx name kenfo #判断name是否有设置过，如果没有才设置
```
setex
```
setex name 10 kenfo #设置有效期10s
```
setrange
```

```

## Hash类型
redis hash是一个string类型的field和value的映射表，
hash特别适合用于存储对象，占用更少内存，方便存取   

hset/hget  
```
hset user:001 name kenfo
hget user:001 name 

```
## List类型
List是一个双向链表结构，主要功能是push,pop,获取一个范围的所有值等。  
list类型其实就是一个每个子元素都是string类型的双向链表。通过push、pop
操作从链表的头部或者尾部添加删除元素，这样list可以当作栈，有可以作为队列使用。
```
lpush:从头部添加字符串元素(栈模式)

rpush:从尾部添加字符串元素（队列模式）

lrange：取数据,eg: lrang name 0 -1 

lset:设置list中指定下标的元素值
lrem:从key对应的list中删除n个和value相同的元素

lpop:从list头部删除元素，并返回删除的元素
rpop:从list尾部删除元素，并返回删除的元素

llen:list的长度

```

## Set类型
Set是集合，它是string类型的无序不重复集合，set是通过hash table实现的   
对集合我们可以取并集，交集，差集。  
通过这些操作我们可以实现sns中的好友推荐和blog的tag功能   
```
sadd: 向名称为key的set中添加元素
smembers: 返回集合中所有元素
srem: 删除元素
spop: 随机返回并删除名称为key的一个元素
sdiff: 返回所有给定key与第一个key的差集
sinter: 返回所有给定key的交集
sunion: 返回所有给定key的并集


```

## Zset类型
sorted set是set的一个升级版本，在set的基础上增加了一个顺序属性，
这一属性在添加修改元素的时候可以指定，每次指定后，zset会自动重新按新的值调整。
可以理解为有两列的mysql表，一列存value，一列存顺序。  
```
zadd: 向名称为key的zset中添加元素member,score用于排序。如果该元素存在，则更新其顺序
zrange: 先升序，然后取元素  
zrevrank: 先降序，然后取元素
```

#### 服务器相关命令
ping:测试连接是否存活  
echo:输入命令  
select：选择数据库   
quit: 退出连接   
dbsize: 返回key的数目   
flushall: 删除所有数据库的所有key   
info: 查询主从信息

##### redis高级实用特性  
1.安全性 
    配置文件中设置密码  requirepass   
2.主从复制
  redis主从复制配置和使用都非常简单，通过主从复制可以允许多个slave拥有和master相同的数据库副本，
  多个slave可以连接master，也可以连接slave。
  - slave与master建立连接，发送sync同步命令
  - master会启动一个后台进程，将数据库快照保存到文件中，并将文件发送给slave    
  - 配置：只需要在slave的配置文件中加入slaveof 192.168.1.1 6379 #指定master ip和端口
       masterauth 123456 #配置master的密码
  
3.事务处理  
redis只能保证一个client发起事务中的命令可以连续执行，而
    中间不会插入其他client命令，当一个client在一个连接中发出
    multi命令时，连接进入一个事务，后续命令不会立即执行，先放到一个
    队列中，当执行exec命令时，redis会顺序执行队列中的命令，事务无法回滚。   
乐观锁复制事务控制，使用watch方式监听，当exec执行时如果监听改变，则事务执行失败    

#### redis应该中如何解决多写的竞争问题:
乐观锁复制事务控制
```
watch price

get price $price

$price = $price + 10

multi

set price $price

exec
```
#### redis使用乐观锁时处理竞争问题，高并发时失败率高如何解决:  

如果同时进行有多个请求进行写操作，例如同一时刻有100个请求过来，那么只会有一个最终成功，其余99个全部会失败，效率不高。
而且从业务层面，有些是不可接受的场景。例如：大家同时去抢一个红包，如果背后也是用乐观锁的机制去处理，那每个请求后都只有一个人成功打开红包，这对业务是不可忍受的。
在这种情况下，如果想让总体效率最大化，可以采用排队的机制进行。
将所有需要对同一个key的请求进行入队操作，然后用一个消费者线程从队头依次读出请求，并对相应的key进行操作。
这样对于同一个key的所有请求就都是顺序访问，正常逻辑下则不会有写失败的情况下产生 。从而最大化写逻辑的总体效率。


    
4.持久化机制
redis是一个支持持久化的内存数据库，经常将内存中的数据同步到硬盘来保证持久化  
持久化方式： 
1）.snapshotting(快照)也是默认方式 ，可以配置redis在n秒内如果超过m个key被修改就发起快照，由于快照一定时间做一次，因此redis突然down掉会丢失一部分数据    
2）.aof方式，redis会将每一个收到的写命令通过write函数追加到文件中，当redis重启时会执行文件中保存的命令

5.发布订阅消息
发布订阅（pub/sub）是一种消息通行模式   
订阅者通过subscribe和psubscribe命令想redis service订阅消息   
发布者通过publish命令想redis server发送特定类型的信息

6.虚拟内存的实用  
将不常用的内存数据放到硬盘   
vm相关配置： 
vm-enabled yes
.... 

## redis集群方案

#### Redis Sentinel  
redis主从复制，如果主突然down掉了，那么需要人工干预才能让slave变成主。  
Redis Sentinel是一个分布式架构，包含若干个Sentinel节点和Redis数据节点，每个Sentinel节点会对数据节点和其余Sentinel节点进行监控，当发现节点不可达时，会对节点做下线标识

#### Redis-Cluster   
1、官方推荐，毋庸置疑。
2、去中心化，集群最大可增加1000个节点，性能随节点增加而线性扩展。
3、管理方便，后续可自行增加或摘除节点，移动分槽等等。
4、简单，易上手。

## 分布式锁
1. 数据库乐观锁；  
2. 基于Redis的分布式锁；  
3. 基于ZooKeeper的分布式锁  

## Redis分布式锁的实现方式
1.单机使用jedis实现分布式锁
2.redis集群方式使用Redisson实现分布式锁  


