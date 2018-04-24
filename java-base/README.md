# java基础

Object类的equals方法和hashCode方法理解：   
equals方法相等，hashcode一定相等，hashcode相等，equals不一样相等，有hash冲突的存在 


#### HashMap
以数据和链表的形式进行存储数据，hash(key)&(len-1)获取数组下标，下标相同的以链表形式存储。   

