package com.kenfo.tree.binarttree;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.tree.binarttree
 * @Description: 二叉树的节点
 * @date 2018/4/22 下午12:38
 */
public class Node {

    private int data;
    private Node leftchild;//左孩子
    private Node rightchild;//右孩子

    public Node(int data){
        this.data = data;
        leftchild = null;
        rightchild = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftchild() {
        return leftchild;
    }

    public void setLeftchild(Node leftchild) {
        this.leftchild = leftchild;
    }

    public Node getRightchild() {
        return rightchild;
    }

    public void setRightchild(Node rightchild) {
        this.rightchild = rightchild;
    }
}
