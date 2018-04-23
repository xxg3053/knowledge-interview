package com.kenfo.linkedlist;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.linkedlist
 * @Description: 链表
 * 链表头不存放数据
 * 链表结尾的next为空
 * 链表不存在大小限制，只要内存即可
 * @date 2018/4/20 下午5:50
 */
public class Link {

    Node head; //头节点

    public Link(){
        head = new Node();//初始化头节点
    }

    /**
     * 新增节点
     * @param data
     */
    public void add(String data){
        Node node = new Node(data);//创建一个节点
        Node temp = head;
        //寻找最后一个节点，最后一个节点的next为空
        while (temp.getNext() != null){
            temp = temp.getNext();
        }
        temp.setNext(node);//添加节点
    }

    /**
     * 插入
     * @param data 需要插入的节点
     * @param after 把data插入到after后面
     */
    public void insert(String data, String after){
        Node node = new Node(data);//创建一个节点
        Node temp = head;
        while (temp.getNext() != null){
            if(temp.getNext().getData().equals(after)){
                node.setNext(temp.getNext().getNext());//设置新增节点的next
                temp.getNext().setNext(node);//插入
                break;
            }
            temp = temp.getNext();
        }
    }
    /**
     * 删除节点
     * @param data 节点值
     */
    public void del(String data){
        //头节点不能删除，里面也不存放数据
        Node temp = head;
        while (temp.getNext() != null){
            if(temp.getNext().getData().equals(data)){
                //删除
                temp.setNext(temp.getNext().getNext());
                break;
            }
            temp =temp.getNext();//改变循环条件
        }
    }

    /**
     * 计算长度
     * @return
     */
    public int size(){
        int len = 0;
        Node temp = head;
        while (temp.getNext() != null){
            len++;
            temp = temp.getNext();//改变循环条件
        }
        return len;
    }

    /**
     * 查找数据
     * @param data
     * @return
     */
    public Node find(String data){
        Node temp = head;
        Node result = null;
        while (temp.getNext() != null){
            if(temp.getNext().getData().equals(data)){
                result = temp.getNext();
                break;
            }
            temp = temp.getNext();
        }

        return result;
    }

    /**
     * 遍历链表
     */
    public void display(){
        Node temp = head;
        while (temp.getNext() != null){
            System.out.print(temp.getNext().getData() + "======>>>");
            temp = temp.getNext();
        }
    }



    public static void main(String[] args) {
        //创建链表
        Link link = new Link();
        link.add("组长审批");
        link.add("部门经理审批");
        link.add("主管副总审批");
        link.add("总经理审批");
        link.display();
        //删除
        link.del("主管副总审批");
        System.out.println("");
        link.display();
        System.out.println("");
        System.out.println("链表的长度：" + link.size());
        Node node = link.find("总经理审批");
        System.out.println(node.getData());
        link.insert("主管副总审批","部门经理审批");
        link.display();
    }
}
