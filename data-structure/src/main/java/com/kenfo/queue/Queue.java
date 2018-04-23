package com.kenfo.queue;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.queue
 * @Description: 队列
 * @date 2018/4/20 下午11:15
 */
public class Queue {

    int size;//队列的大小
    int front;//头指针
    int rear; //尾指针
    Object data[] = null;//保存数据的数组

    public Queue(){
        size = 10;
        front = -1;
        rear = -1;
        data = new Object[size];
    }

    public Queue(int size){
        this.size = size;
        front = -1;
        rear = -1;
        data = new Object[size];
    }



}
