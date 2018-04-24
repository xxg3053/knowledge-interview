# mysql

索引的几种类型: 
单值索引:即一个索引只包含单个列，一个表可以有多个单列索引。  
唯一索引:索引列的值必须唯一，但允许有空值。   
复合索引:即一个索引包含多个列。  

基本语法：  
```
CREATE [UNIQUE] INDEX indexName ON mytable(columnname(length)); 

ALTER mytable ADD [UNIQUE] INDEX[indexName] ON (columnname(length));

```

事务传播性和隔离性  

事务的基本要素（ACID）

1、原子性（Atomicity）：事务开始后所有操作，要么全部做完，要么全部不做，不可能停滞在中间环节。事务执行过程中出错，会回滚到事务开始前的状态，所有的操作就像没有发生一样。也就是说事务是一个不可分割的整体，就像化学中学过的原子，是物质构成的基本单位。　　 
2、一致性（Consistency）：事务开始前和结束后，数据库的完整性约束没有被破坏 。比如A向B转账，不可能A扣了钱，B却没收到。
3、隔离性（Isolation）：同一时间，只允许一个事务请求同一数据，不同的事务之间彼此没有任何干扰。比如A正在从一张银行卡中取钱，在A取钱的过程结束前，B不能向这张卡转账。
4、持久性（Durability）：事务完成后，事务对数据库的所有更新将被保存到数据库，不能回滚。

##### MySQL事务隔离级别
博文：https://www.cnblogs.com/huanongying/p/7021555.html   

事务隔离级别	                脏读	   不可重复读	   幻读
读未提交（read-uncommitted）	是	是	是
不可重复读（read-committed）	否	是	是
可重复读（repeatable-read）	否	否	是
串行化（serializable）	    否	否	否
 

mysql默认的事务隔离级别为repeatable-read
```
select @@tx_isolation;

```

乐观锁和悲观锁  

注：要使用悲观锁，我们必须关闭mysql数据库的自动提交属性，因为MySQL默认使用autocommit模式，
也就是说，当你执行一个更新操作后，MySQL会立刻将结果进行提交。 

补充：MySQL select…for update的Row Lock与Table Lock
使用select…for update会把数据给锁住，不过我们需要注意一些锁的级别，
MySQL InnoDB默认Row-Level Lock，所以只有「明确」地指定主键，
MySQL 才会执行Row lock (只锁住被选取的数据) ，
否则MySQL 将会执行Table Lock (将整个数据表单给锁住)。 