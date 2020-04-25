package com.gourddoll.blog.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    //为什么必须是静态？
    public static String getTimestamp(){
        //获得系统时间.
        Date date = new Date();
        //将时间格式转换成符合Timestamp要求的格式.2020-04-09 21:16:10
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        //把时间转换成timestamp
        //Timestamp goodsC_date =Timestamp.valueOf(nowTime);
        return nowTime;
    }
}
