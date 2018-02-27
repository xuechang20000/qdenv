package com.xuechen.core.utils;

public class StringTools {

    public  static  boolean hasText(String s){
        if(s==null||"".equals(s.trim())) return false;
        return true;
    }
}
