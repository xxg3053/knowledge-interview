package com.kenfo.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.date
 * @Description: 日期比较
 * @date 2018/5/25 下午10:04
 */
public class Compare {

    public static void main(String[] args) {
        //日期比较
        try {
            Date fd = Compare.toDate("2017-09-09 10:11:11", "yyyy-MM-dd");
            System.out.println(Compare.isBeforeDate(fd));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 闯入日期与系统日期比较 ,比较格式yyyy-MM-dd
     * @param date
     */
    public static boolean isBeforeDate(Date date){
        boolean flag = false;
        try {
            Date datef = Compare.format(date, "yyyy-MM-dd");
            Date now = Compare.format(new Date(), "yyyy-MM-dd");
            flag = datef.before(now);
        }catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }

    public static Date format(Date date, String format) throws Exception{
        DateFormat df = new SimpleDateFormat(format);
        return df.parse(df.format(date));
    }

    public static Date toDate(String date, String format) throws Exception{
        DateFormat df = new SimpleDateFormat(format);
        return df.parse(date);
    }
}
