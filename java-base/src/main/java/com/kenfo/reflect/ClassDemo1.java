package com.kenfo.reflect;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.imooc.reflect
 * @Description: Class类的使用
 * @date 2018/2/26 下午9:56
 */
public class ClassDemo1 {

    public static void main(String[] args) {
        //Foo的实例对象如何表示
        Foo foo1 = new Foo();//foo1就表示出来了
        //Foo这个类也是一个实例对象，Class类的实例对象，如何表示呢？不能new出来
        //任何一个类都是Class类的实例对象，这个实例对象有三种表示方式：
        //第一种表示方式，任何一个类都有一个隐含的静态成员变量class
        Class c1 = Foo.class;
        //第二种表达方式，已知该类的对象通过getClass方法
        Class c2 = foo1.getClass();
        /*官网c1,c2表示了Foo类的类类型（class type）
        * 万事万物皆对象
        * 类也是对象，是Class类的实例对象
        * 这个对象我们称为该类的类类型
        *
        * */
        //一个类只可能是Class类的一个实例对象
        System.out.println(c1 == c2);//true

        //第三种表达方式
        Class c3 = null;
        try {
            c3 = Class.forName("com.imooc.reflect.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c2 == c3);//true

        //我们完成可以通类的类类型创建该类的对象实例，通过c1,c2,c3创建Foo的实例
        try {
            Foo foo = (Foo)c1.newInstance();//需要有无参数的构造方法
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}


class Foo{}