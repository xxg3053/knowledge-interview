package com.kenfo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo
 * @Description: TODO
 * @date 2018/4/25 下午6:09
 */
public class ScanTest {

    public static void main(String[] args) {
        Jedis jedis = null;
        try{
            jedis = RedisUtils.getRedis();
//          for(int i=0; i<1000; i++){
//             jedis.set("scan"+i, i+"");
//          }

            long t1 = System.currentTimeMillis();
            jedis.keys("*");//keys应该在生产环境禁止掉
            long t2 = System.currentTimeMillis();
            System.out.println("keys耗时：" + (t2-t1));

            ScanParams scanParams = new ScanParams();
            // 设置每次scan个数
            scanParams.count(100);
            String scanRet = "0";
            long t3 = System.currentTimeMillis();
            List<String> retList = new ArrayList<>();
            do{
                 ScanResult ret = jedis.scan(scanRet, scanParams.match("*"));
                //ScanResult ret = jedis.scan(scanRet);
                scanRet = ret.getStringCursor();
                System.out.print(scanRet + "\t");
                retList.addAll(ret.getResult());
            }while (!scanRet.equals("0"));
            long t4 = System.currentTimeMillis();

            System.out.println("scan耗时：" + (t4-t3));
            System.out.println("结果大小：" + retList.size());
        }catch (Exception e){

        }finally {
            if(jedis != null){
                jedis.close();
            }

        }

    }
}
