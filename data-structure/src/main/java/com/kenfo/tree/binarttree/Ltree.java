package com.kenfo.tree.binarttree;

import com.sun.org.apache.xpath.internal.operations.Lt;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.tree.binarttree
 * @Description: 链表实现二叉树
 * 优点：不浪费内存空间
 * 缺点：寻找父节点很困难
 *
 * 数组和链表表示二叉树的优点和缺点正好相反
 *
 * @date 2018/4/22 下午12:37
 */
public class Ltree {

    Node root = null;//根节点

    public Ltree(int data){
        root = new Node(data);
    }

    public void add(int data){
        Node d = new Node(data);
        Node p = root; //获取头节点
        while (true){
            if(p.getData() >= data){ //往左走
                if(p.getLeftchild() != null){
                    p = p.getLeftchild();
                }else {
                    p.setLeftchild(d);//新增
                    break;
                }

            }else{//往右走
                if(p.getRightchild() != null){
                    p = p.getRightchild();
                }else {
                    p.setRightchild(d);
                    break;
                }
            }
        }

    }

    /**
     * 遍历
     */
    public void display(Node root){//函数的递归调用
        Node p = root;

       // System.out.println("节点：" +p.getData());//先根遍历

        if(p.getLeftchild() != null){
            display(p.getLeftchild());
        }
        // System.out.println("节点：" +p.getData());//中根遍历，一定是有序的
        if(p.getRightchild() != null){
            display(p.getRightchild());
        }
         System.out.println("节点：" +p.getData());//后根遍历
    }


    public static void main(String[] args) {
        Ltree ltree = new Ltree(10);
        ltree.add(8);
        ltree.add(7);
        ltree.add(3);
        ltree.add(11);
        ltree.add(20);
        ltree.display(ltree.root);
    }
}
