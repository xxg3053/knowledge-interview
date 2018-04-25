package com.kenfo.concurrent.countdownlatch.healthcheck;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.concurrent.countdownlatch
 * @Description: TODO
 * @date 2018/4/25 下午5:20
 */
public class Main {

    public static void main(String[] args) {
        boolean result = false;
        try {
            result = ApplicationStartupUtil.checkExternalServices();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("External services validation completed !! Result was :: "+ result);

    }
}
