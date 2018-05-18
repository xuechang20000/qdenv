package com.xuechen.web.utils;

import com.xuechen.web.dto.AppUserDTO;
import org.apache.shiro.SecurityUtils;

public class ContextUtils {
    public static AppUserDTO getUser(){
        AppUserDTO appUserDTO= (AppUserDTO)
                SecurityUtils.getSubject().getSession().getAttribute("user");
        return  appUserDTO;
    }
    public static String getLoginname(){
        return getUser().getLoginname();
    }
    public static String getUserName(){
        return getUser().getName();
    }
    public static Integer getUserId(){
       return getUser().getUserId();
    }
}
