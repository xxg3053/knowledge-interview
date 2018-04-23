package com.kenfo.tree.binarttree;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.tree.binarttree
 * @Description: 二叉树数组方式表示
 * 缺点：浪费空间
 * 优点：很容易找到其父节点、子节点及兄弟
 * @date 2018/4/21 上午12:44
 */
public class TreeDemo {

    int btree[];
    int root = 1;
    int leftchild;
    int rightchild;


    public TreeDemo(int root){
        btree = new int[16];
        btree[1] = root;//根节点
    }


    /**
     * 二叉树新增
     * 小于父节点的放左边，大于父节点的放右边
     * 左孩子的下标 = 父节点的下标 * 2
     * 右孩子的下标 = 父节点的下标 * 2 + 1
     *
     * 数组实现二叉树的缺陷：浪费很多的存储空间
     *
     * @param data
     */
    public void add(int data){
        root = 1;//初始化根节点
        while (btree[root] != 0){
            if(btree[root] >= data){//往左走
                root = root * 2;
            }else if(btree[root] < data){//往右走
                root = root * 2 + 1;
            }
        }
        btree[root] = data;
    }

    /**
     * 删除节点
     * @param data
     */
    public void del(int data){
        root = 1;
        while (btree[root] != data){
            if(btree[root] > data){//往左走
                root = root * 2;
            }else if(btree[root] < data){//往右走
                root = root * 2 + 1;
            }
        }
        btree[root] = 0;
    }

    /**
     * 查找
     * @param data
     */
    public int find(int data){
        root = 1;
        while (btree[root] != data){
            if(btree[root] > data){//往左走
                root = root * 2;
            }else if(btree[root] < data){//往右走
                root = root * 2 + 1;
            }
        }
        return root;
    }

    public void display(){
        System.out.println("遍历：");
        for(int i=0; i<btree.length; i++){
            System.out.println(btree[i]);
        }
    }

    public static void main(String[] args) {
        TreeDemo treeDemo = new TreeDemo(10);
        treeDemo.add(8);
        treeDemo.add(7);
        treeDemo.add(11);
        treeDemo.add(3);
        treeDemo.add(20);
        treeDemo.display();
        System.out.println(treeDemo.find(7));
    }


}
