package com.xuechen.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringTools {

    public  static  boolean hasText(String s){
        if(s==null||"".equals(s.trim())) return false;
        return true;
    }
    public static String formatDate(Date date, String format){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }
    public static String formatNowDate(String format){
        if (format==null) return  formatDate(new Date(),"yyyy-MM-dd");

        return  formatDate(new Date(),format);
    }
}
