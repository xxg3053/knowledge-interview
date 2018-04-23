package com.kenfo.stack;

import java.util.Stack;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.stack
 * @Description: 堆栈Stack类
 * @date 2018/4/20 下午8:58
 */
public class StackDemo {

    public static void main(String[] args) {
        Stack<String> qingjia = new Stack<String>();
        qingjia.push("组长审批");
        qingjia.push("部门经理审批");
        qingjia.push("副总审批");
        qingjia.push("董事长审批");

        System.out.println("size=" + qingjia.size());
        System.out.println("栈顶：" + qingjia.peek());
        while (!qingjia.empty()){
            System.out.print(qingjia.pop() + "-->");
        }
        System.out.println("size=" + qingjia.size());
        System.out.println("容量=" + qingjia.capacity());



    }
}
