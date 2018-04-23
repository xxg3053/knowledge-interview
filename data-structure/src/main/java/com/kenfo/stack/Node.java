package com.kenfo.stack;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.stack
 * @Description: 链表节点
 * @date 2018/4/20 下午9:42
 */
public class Node {

    private Object data;
    private Node next;
    //创建头节点
    public Node(){
        data = null;
        next = null;
    }
    //添加节点
    public Node(Object data){
        this.data = data;
        next = null;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
