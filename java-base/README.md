# java基础

Object类的equals方法和hashCode方法理解：   
equals方法相等，hashcode一定相等，hashcode相等，equals不一样相等，有hash冲突的存在 


#### HashMap
以数据和链表的形式进行存储数据，hash(key)&(len-1)获取数组下标，下标相同的以链表形式存储。   

#### 对象排序
java对象排序，实现comparable接口，重写compareTo方法


## CountDownLatch、CyclicBarrier和 Semaphore

#### CountDownLatch
CountDownLatch类位于java.util.concurrent包下，利用它可以实现类似计数器的功能。
比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了。

#### CyclicBarrier
字面意思回环栅栏，通过它可以实现让一组线程等待至某个状态之后再全部同时执行。
叫做回环是因为当所有等待线程都被释放以后，CyclicBarrier可以被重用。
我们暂且把这个状态就叫做barrier，当调用await()方法之后，线程就处于barrier了


#### Semaphore
Semaphore翻译成字面意思为 信号量，Semaphore可以控同时访问的线程个数，
通过 acquire() 获取一个许可，如果没有就等待，而 release() 释放一个许可。  


## 多线程

wait和sleep

wait在notity后不是直接执行，而是在竞争到锁之后才执行
