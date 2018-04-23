package com.kenfo.linkedlist;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.linkedlist
 * @Description: 链表节点
 * @date 2018/4/20 下午5:46
 */
public class Node {

    private String data;//数据域 可以是任何类型
    private Node next;//链域（下一个节点的地址）

    public Node(){
        this.data = "";
        this.next = null;
    }

    public Node(String data){
        this.data = data;
        next = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
