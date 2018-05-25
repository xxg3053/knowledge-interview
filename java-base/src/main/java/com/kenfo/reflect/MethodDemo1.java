package com.kenfo.reflect;


import java.lang.reflect.Method;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.imooc.reflect
 * @Description: TODO
 * @date 2018/2/27 下午10:59
 */
public class MethodDemo1 {

    public static void main(String[] args) {
        //要获取print(int,int)方法
        //1，要获取一个方法就要获取类的信息，获取类的信息首先要获取类的类类型
        A a1 = new A();
        Class c = a1.getClass();
        /**
         * 2. 获取方法名称和参数列表来决定
         * getMethod获取的是public的方法
         * getDelcaredMethod自己声明的方法
         */
        try {
            //Method m = c.getMethod("print", new Class[]{int.class,int.class});
            Method m = c.getMethod("print", int.class,int.class);

            //方法的发射操作，是用m对象进行方法的调用
            //a1.print(10,20)
            //方法如果没有返回值返回null,有返回值返回具体的返回值类型
            //m.invoke(a1, new Object[]{10,20});
            m.invoke(a1, 10,20);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class A{
    public void print(int a,int b){
        System.out.print(a+b);
    }

    public void print(String a,String b){
        System.out.print(a.toUpperCase() + "," + b.toUpperCase());
    }
}
