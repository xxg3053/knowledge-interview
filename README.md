# 知识点

## Object类的方法(平安)   
clone()  
equals(object)  
finalize()  
getClass()   
hashCode()   
notify()   
notifyAll()   
toString()   
wait()   

## String 
String、StringBuffer、StringBuilder三者的区别：   
都在java.lang 包下
String使用final修饰，不可变，每次字符串变更都是创建新的字符串，String s = “a”+"b"除外，频繁变更会导致无引用对象过多，导致gc影响性能。
StringBuffer是线程安全的，每次变更是对本身进行操作，不会产生新对象，效率要高
StringBuilder是非线程安全，一般情况下优先使用，速度要优于StringBuffer

HashMap以数组和链表形式存储数据，默认大小为16，通过hash(key)&(len-1)方式获取下标，相同下标的数据通过链表形式存储

## 多线程
通过executors创建线程池的方式：    
newFixedthreadPool创建固定大小的线程池，linkedBlockingQueue等待队列大小为整形最大值    
newSingleThreadPool创建只有一个线程的线程池    
newCachedThreadPool 创建的线程存活时间一分钟   


线程池大小 = cpu个数*cpu期望利用率*（1 + 任务等待时间/任务处理时间）   


## SOA
分布式cap理论：数据一致性，服务可用性，故障容错性，zk是cp，eureka是ap  


orcale建立索引：create index indexname on table(field);

## Mybatis
```
#{}是经过预编译，可以防止sql注入，${}仅仅是取变量的值替换，不安全
```
 

## 缓存

Redis支持的数据类型：String, hash, List, Set, Zset
redis管道技术提高缓存读取性能，pepiline方式打包发送命令

缓存穿透，缓存击穿问题:   
大量缓存不能设置为相同超时时间，超时时间添加随机参数   
使用redis、memeache等缓存技术的互斥锁机制防止单点缓存击穿   



## Spring 
spring的相关注解：@Component @Repository @Service @Controller

## 定时器
定时器任务：quartz实现，java的Timer类，Spring注解@scheduled实现

## List
list去重：
通过循环方式：
```
 List<String> newList = new  ArrayList<String>(); 
     for (String cd:list) {
             if(!newList.contains(cd)){
                 newList.add(cd);
             }
         }
```
 
通过set方式
```
Set set = new  HashSet(); 
List newList = new  ArrayList(); 
set.addAll(list);
newList.addAll(set);
```


//去重并且按照自然顺序排列
List newList = new ArrayList(new TreeSet(list));

## Servlet
servlet 是线程不安全的   


## 海量数据处理解决方案
Hash取模，分而治之，HashMap统计，堆/快速/归并排序  

Bloom filterBitmap方式

## 配置中心
spring cloud config    
netflix archaius   
ctrip apollo    
disconf   
hawk   
