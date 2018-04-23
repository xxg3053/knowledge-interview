package com.kenfo.stack;


/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.stack
 * @Description: 使用数组实现堆栈
 * @date 2018/4/20 下午9:04
 */
public class ArrayOfStack {

    Object stack[] = null;
    int size;
    int top;//栈顶指针，实际为数组下标

    public ArrayOfStack(){
        stack = new Object[100];
        size = 100;
        top = -1;
    }
    public ArrayOfStack(int size){
        this.size = size;
        stack = new Object[size];
        top = -1;
    }

    /**
     * 判断堆栈是否为空
     * @return
     */
    public boolean isEmpty(){
        if(top == -1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 判断堆栈是否已满
     * @return
     */
    public boolean isFull(){
        if(top == (size -1)){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 入栈
     * @param item
     */
    public void push(Object item){
        //判断堆栈是否满了
        if(isFull()){
            System.out.println("堆栈已满");
            return;
        }
        top++;
        stack[top] = item;
    }

    /**
     * 出栈
     * @return
     */
    public Object pop(){
        Object item = null;
        if(isEmpty()){
            System.out.println("堆栈为空");
            return null;
        }
        item = stack[top];
        top--;//改变栈顶位置

        return item;
    }

    /**
     * 读取栈顶元素
     * 不改变top值
     * @return
     */
    public Object peek(){
        Object item = null;
        if(isEmpty()){
            System.out.println("堆栈为空");
            return null;
        }
        item = stack[top];
        return item;
    }

    /**
     * 堆栈大小
     * @return
     */
    public int size(){
        return top + 1;
    }

    /**
     * 容量
     * @return
     */
    public int capacity(){
        return size;
    }


    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        ArrayOfStack qingjia = new ArrayOfStack();
        qingjia.push("组长审批");
        qingjia.push("部门经理审批");
        qingjia.push("副总审批");
        qingjia.push("董事长审批");

        System.out.println("size=" + qingjia.size());
        System.out.println("栈顶：" + qingjia.peek());
        while (!qingjia.isEmpty()){
            System.out.print(qingjia.pop() + "-->");
        }
        System.out.println("size=" + qingjia.size());
        System.out.println("容量=" + qingjia.capacity());

    }

}
