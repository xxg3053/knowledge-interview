package com.kenfo.reflect.dynamic;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.imooc.reflect.dynamic
 * @Description: 类的动态加载
 * @date 2018/2/26 下午10:27
 */
public class Office {

    public static void main(String[] args) {

        //new创建对象是静态加载类，在编译时刻就需要加载所有的可能使用到的类
        //通过动态加载类可以解决该问题
        if("word".equals(args[0])){
            Word w = new Word();
            w.start();
        }

        if("excel".equals(args[0])){
            //Excel e = new Excel();
            //e.start();
        }
    }
}
