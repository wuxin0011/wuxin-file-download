package com.wuxin.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: wuxin001
 * @Date: 2022/04/06/19:12
 * @Description:
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        System.out.println("sout ...");
        // date01();
        // date02();
        // date03();
        // Demo01 demo01 = new Demo01();
        // System.out.println(new Demo01().hashCode());
        // Demo01 demo01 = new Demo01();
        // System.out.println(demo01.hashCode());
        // String s = Integer.toHexString(demo01.hashCode());
        // System.out.println(s);
        // System.out.println(demo01.toString());
        // System.out.println(demo01.clone().equals(demo01));
    }



    public static void date01(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }

    public static void date02(){
        Calendar instance = Calendar.getInstance();
        int month = Calendar.MONTH;
        // System.out.println(instance);
        Date time = instance.getTime();
        // System.out.println(time);
        Date time1 = instance.getTime();
        String calendarType = instance.getCalendarType();
        System.out.println(calendarType);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
        System.out.println(format);

        Calendar build = new Calendar.Builder().build();
        System.out.println(build);
        build.setTimeInMillis(System.currentTimeMillis());
    }

    public static void date03(){
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));
    }
}
