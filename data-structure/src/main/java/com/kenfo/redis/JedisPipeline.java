package com.kenfo.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.redis
 * @Description: TODO
 * @date 2018/4/23 下午10:08
 */
public class JedisPipeline {
    static Jedis jedis;
    static {
         jedis = new Jedis("172.16.92.218", 6379);
         jedis.auth("123456");
    }

    public static void testUnUsePipeline() {
        long start = new Date().getTime();
        System.out.println(jedis.flushDB());
        for (int i = 0; i < 1000; i++) {
            jedis.set("name" + i, i + "");
            jedis.get("name" + i);// 每个操作都发送请求给redis-server
        }
        long end = new Date().getTime();
       // System.out.println(jedis.keys("name*"));
        System.out.println("unuse pipeline cost:" + (end - start) + "ms");

    }

    public static void testUsePipeline() {
        long start = new Date().getTime();

        jedis.flushDB();
        Pipeline p = jedis.pipelined();
        List result = new ArrayList();
        for (int i = 0; i < 1000; i++) {
            p.set("age" + i, i + "");
            result.add(p.get("age" + i));
        }
        p.sync();// 一次性发给redis-server
        //System.out.println(jedis.keys("age*"));
        long end = new Date().getTime();
        System.out.println("use pipeline cost:" + (end - start) + "ms");
        System.out.println("总共结果：" + result.size());
    }

    public static void main(String[] args) {
        testUnUsePipeline();
        testUsePipeline();
    }

}
