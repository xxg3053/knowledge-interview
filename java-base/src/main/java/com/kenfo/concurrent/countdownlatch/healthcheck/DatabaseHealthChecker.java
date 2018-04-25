package com.kenfo.concurrent.countdownlatch.healthcheck;

import java.util.concurrent.CountDownLatch;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.concurrent.countdownlatch
 * @Description: 数据库检查服务
 * @date 2018/4/25 下午5:12
 */
public class DatabaseHealthChecker extends BaseHealthChecker {

    public DatabaseHealthChecker(CountDownLatch latch){
        super("Database service", latch);
    }

    @Override
    public void verifyService() {
        System.out.println("Checking " + this.getServiceName());
        try
        {
            Thread.sleep(8000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }
}
