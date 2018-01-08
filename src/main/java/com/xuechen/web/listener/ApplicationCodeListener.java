package com.xuechen.web.listener;


import com.xuechen.web.bo.AppDict;
import com.xuechen.web.bo.AppDictDetail;
import com.xuechen.web.service.AdminService;
import org.apache.log4j.Logger;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

public class ApplicationCodeListener implements ServletContextListener {
    private static Logger logger = Logger.getLogger(ApplicationCodeListener.class);

    public void contextDestroyed(ServletContextEvent contextEvent) {

    }


    public void contextInitialized(ServletContextEvent contextEvent) {
        logger.info("loading code begin...");
        AdminService adminService=
        WebApplicationContextUtils.getRequiredWebApplicationContext(contextEvent.getServletContext()).getBean(AdminService.class);
        ServletContext context = contextEvent.getServletContext();
        AppDict appDict=new AppDict();
        appDict.setStatus("1");
        List<AppDict> appDicts = adminService.queryAppDicts(appDict);
        if(appDicts!=null){
            AppDictDetail appDictDetail;
            for(int i=0;i<appDicts.size();i++){
                appDictDetail=new AppDictDetail();
                appDictDetail.setStatus("1");
                appDictDetail.setDictCode(appDicts.get(i).getDictCode());
                List<AppDictDetail> appDictDetails = adminService.queryAppDictDetails(appDictDetail);
                if(appDictDetails!=null&&appDictDetails.size()>0){
                    if(appDicts.get(i).getDictCode()!=null)
                        context.setAttribute(appDicts.get(i).getDictCode(), appDictDetails);
                }
            }
        }
        logger.info("loading code end...");
    }


}
