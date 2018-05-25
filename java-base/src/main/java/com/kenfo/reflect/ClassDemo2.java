package com.kenfo.reflect;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.imooc.reflect
 * @Description: 基本数据类型 void关键字都存在类类型
 * @date 2018/2/26 下午10:40
 */
public class ClassDemo2 {

    public static void main(String[] args) {

        Class c1 = int.class;//int的类类型
        Class c2 = String.class;//String类的类类型 String类的字节码（自己发明）
        Class c3 = double.class;
        Class c4 = Double.class;
        Class c5 = void.class;


        System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c2.getSimpleName());
    }
}
