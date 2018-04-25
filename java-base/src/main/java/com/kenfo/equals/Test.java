package com.kenfo.equals;

import java.util.Objects;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.equals
 * @Description: 重写equals、hashcode方法
 *
 * 重写equals()方法就必须重写hashCode()方法的原因:
 * 假设两个对象，重写了其equals方法，其相等条件是属性相等，就返回true。
 * 如果不重写hashcode方法，其返回的依然是两个对象的内存地址值，必然不相等。
 * 这就出现了equals方法相等，但是hashcode不相等的情况。这不符合hashcode的规则
 *
 * @date 2018/4/24 下午5:33
 */
public class Test {

    public static void main(String[] args) {
        User1 u1 = new User1("kenfo", 20, "123456");
        User1 u2 = new User1("kenfo", 20, "123456");

        System.out.println(u1.equals(u2));
    }

}
