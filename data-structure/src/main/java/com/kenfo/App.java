package com.kenfo;

/**
 * Hello world!
 *
 */
public class App
{
    static {
        System.out.println("静态代码块");
    }
    {
        System.out.println("代码块");
    }
    public App(){
        System.out.println("构造方法");
    }


    public static void main( String[] args )
    {
        System.out.println("开始");
        App t = new App();
        System.out.println("结束");
        App t2 = new App();

    }
}


