package com.kenfo.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.imooc.reflect
 * @Description: 通过反射了解集合泛型的本质
 * @date 2018/2/27 下午11:14
 */
public class MethodDemo4 {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("hello");
        //list1.add(20);错误
        Class c1 = list.getClass();
        Class c2 = list1.getClass();
        System.out.println(c1 == c2);//true
        //反射的操作都是编译之后的操作

        /**
         * c1==c2结果返回true说明编译之后集合的泛型是去泛型化的
         * java中集合的泛型，是防止错误输入的，只在编译阶段有效，
         * 绕过编译就无效了
         * 验证：我们可以通过方法的反射操作，绕过编译
         */

        Method m = null;
        try {
            m = c1.getMethod("add",Object.class);
            m.invoke(list1, 1);//绕过编译操作就绕过了泛型

            System.out.println(list1.size());//1
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
