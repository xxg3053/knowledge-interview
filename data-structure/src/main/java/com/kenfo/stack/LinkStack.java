package com.kenfo.stack;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.stack
 * @Description: 链表实现堆栈
 * @date 2018/4/20 下午9:45
 */
public class LinkStack {

    Node head = null;

    public LinkStack(){
        head = new Node();
    }

    /**
     * 入栈
     * @param item
     */
    public void push(Object item){
        Node p = new Node(item);
        p.setNext(head.getNext());
        head.setNext(p);
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        if(head.getNext() == null){
            return true;
        }else {
            return false;
        }
    }
    /**
     * 出栈
     * @return
     */
    public Object pop(){
        Object item = null;
        if(isEmpty()){
            System.out.println("堆栈为空...");
            return item;
        }
        item = head.getNext().getData();
        head.setNext(head.getNext().getNext());//移动下标
        return item;
    }

    /**
     * 读取堆栈大小
     * @return
     */
    public int size(){
        int len = 0;
        Node temp = head;
        while (temp.getNext() != null ){
            len++;
            temp = temp.getNext();
        }
        return len;
    }

    /**
     * 读取栈顶元素
     * @return
     */
    public Object peek(){
        Object item = null;
        if(isEmpty()){
            return item;
        }
        item = head.getNext().getData();
        return item;
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        LinkStack stack = new LinkStack();
        //判断表达式语法是否正确，主要是判断括号
        String str = "((a+b)* (c+d) + (x*y)) * (m+n);";
        int len = str.length();
        for(int i=0; i<len; i++){
            //如果碰到左括号就入栈，如果碰到右括号就出栈
            if(str.charAt(i) == '('){
                stack.push(str.charAt(i));//入栈
            }else if(str.charAt(i) == ')'){
                if(stack.isEmpty()){
                    System.out.println("无法错误，缺少左括号");
                    return;
                }
                stack.pop();//出栈
            }
        }
        if(stack.isEmpty()){
            System.out.println("括号匹配正常");
        }else {
            System.out.println("语法错误，缺少右括号");
        }


        /**
         LinkStack qingjia = new LinkStack();
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
         **/
    }
}
