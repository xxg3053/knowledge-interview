package com.kenfo.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.collection
 * @Description:
 *
 * 不要在foreach循环进行元素的add/remove.
 * remove元素请使用Iterator方式，
 * 如果并发操作，需要对Iterator对象加锁
 * @date 2018/5/31 下午4:30
 */
public class ListRemove {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        /**正确
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            String item = it.next();
            //System.out.println(item);
            if("2".equals(item)){
                it.remove();
            }
        }
         **/
        /**错误**/
        for(String i:list){
            if("2".equals(i)){
                list.remove(i);
            }
        }

       list.forEach(System.out::print);
    }


}
