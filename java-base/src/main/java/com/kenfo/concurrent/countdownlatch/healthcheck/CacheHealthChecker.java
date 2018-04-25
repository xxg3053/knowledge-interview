package com.kenfo.concurrent.countdownlatch.healthcheck;

import java.util.concurrent.CountDownLatch;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.concurrent.countdownlatch
 * @Description: 缓存检查服务
 * @date 2018/4/25 下午5:14
 */
public class CacheHealthChecker extends BaseHealthChecker {

    public CacheHealthChecker(CountDownLatch latch){
        super("Cache service" , latch);
    }
    @Override
    public void verifyService() {
        System.out.println("Checking " + this.getServiceName());
        try
        {
            Thread.sleep(9000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }
}
