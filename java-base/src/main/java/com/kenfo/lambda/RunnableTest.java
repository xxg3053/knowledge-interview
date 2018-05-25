package com.kenfo.lambda;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.lambda
 * @Description: 用lambda实现Runable接口
 *
 *  (params) -> expression
    (params) -> statement
    (params) -> { statements }

 * @date 2018/5/15 下午11:20
 */
public class RunnableTest {

    public void oldThead(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before java 8, too match code fot this");
            }
        }).start();
    }

    public void newThead(){
        new Thread(() -> System.out.println("In java 8")).start();
    }

    public static void main(String[] args) {
        RunnableTest runnableTest = new RunnableTest();
        runnableTest.oldThead();
        runnableTest.newThead();
    }


}
