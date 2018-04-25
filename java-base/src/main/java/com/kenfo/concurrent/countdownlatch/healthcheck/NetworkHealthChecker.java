package com.kenfo.concurrent.countdownlatch.healthcheck;

import java.util.concurrent.CountDownLatch;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.concurrent.countdownlatch
 * @Description: 网络检测
 * @date 2018/4/25 下午5:10
 */
public class NetworkHealthChecker extends BaseHealthChecker{

    public NetworkHealthChecker (CountDownLatch latch)  {
        super("Network Service", latch);
    }


    @Override
    public void verifyService() {
        System.out.println("Checking " + this.getServiceName());
        try
        {
            Thread.sleep(7000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }
}
