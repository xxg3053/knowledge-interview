package com.kenfo;

import redis.clients.jedis.*;

import java.util.LinkedList;
import java.util.List;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.redis
 * @Description: TODO
 * @date 2018/4/23 下午10:13
 */
public class RedisUtils {
   // private static ShardedJedisPool pool;
    static Jedis jedis;

    static {
//        JedisPoolConfig config = new JedisPoolConfig();
//        config.setMaxTotal(100);
//        config.setMaxIdle(50);
//        config.setMaxWaitMillis(3000);
//        config.setTestOnBorrow(true);
//        config.setTestOnReturn(true);
//        // 集群
//        JedisShardInfo jedisShardInfo1 = new JedisShardInfo("172.16.92.218", 6379);
//        jedisShardInfo1.setPassword("123456");
//        List<JedisShardInfo> list = new LinkedList<JedisShardInfo>();
//        list.add(jedisShardInfo1);
//        pool = new ShardedJedisPool(config, list);

        jedis = new Jedis("172.16.92.218", 6379);
        jedis.auth("123456");
    }
    /**
    public static ShardedJedis getRedis(){
        return pool.getResource();
    }**/

    public static Jedis getRedis(){
        return jedis;
    }




}
