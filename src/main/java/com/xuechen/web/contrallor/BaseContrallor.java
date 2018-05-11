package com.xuechen.web.contrallor;

import com.wondersgroup.framwork.dao.bo.Page;
import com.xuechen.qdenv.service.QdenvServiceImpl;
import com.xuechen.web.service.BaseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

@Controller
public class BaseContrallor {

    private static Logger logger= Logger.getLogger(QdenvServiceImpl.class);

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;



    @Autowired
    private BaseService baseService;
    /**
     * 导出grid到excle
     * @param request
     * @param response
     */
    @RequestMapping("/work/export/exportGridToExcle")
    public void exportGridToExcle(HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, InstantiationException, InvocationTargetException, IOException {
        String errorMsg;
        String url=request.getParameter("exp_url");
        if (url==null){
            writeToClient(response,"传入请求地址为空！");
            return;
        }
        HandlerMethod handlerMethod=getHanderMethod(url);
        if(handlerMethod==null) return;

        //获取请求contrallor
        Object contrallor= this.requestMappingHandlerMapping.getApplicationContext().getBean(handlerMethod.getBeanType());
        MethodParameter[] methodParameters=handlerMethod.getMethodParameters();
        Object[] objects=new Object[methodParameters.length];
        //参数绑定
        ServletRequestDataBinder servletRequestDataBinder=null;
        for (int i=0;i<methodParameters.length;i++){
            MethodParameter methodParameter=methodParameters[i];
            Object object=methodParameter.getParameterType().newInstance();
            servletRequestDataBinder=new ServletRequestDataBinder(object);
            servletRequestDataBinder.bind(request);
            objects[i]=object;
        }
        Object retObj=handlerMethod.getMethod().invoke(contrallor,objects);
        String headers=request.getParameter("exp_header");
        //输出文件
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("content-disposition", "attachment;filename="+UUID.randomUUID().toString()+".xls");
        this.baseService.exportExcel(response.getOutputStream(),
                request.getSession().getServletContext(),headers,retObj.toString());
    }


    public  HandlerMethod getHanderMethod(String url){
        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();

        for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
            RequestMappingInfo info = m.getKey();
            if (info.getPatternsCondition().toString().equals("["+url+"]"))
                return m.getValue();
        }
        return  null;
    }
    public void writeToClient(HttpServletResponse response,String message) {
        OutputStream os=null;
        byte[] bytes=new byte[1024];
        try {
            os=response.getOutputStream();
            try {
                bytes=message.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            os.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                os.flush();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return requestMappingHandlerMapping;
    }

    public void setRequestMappingHandlerMapping(RequestMappingHandlerMapping requestMappingHandlerMapping) {
        this.requestMappingHandlerMapping = requestMappingHandlerMapping;
    }
    public BaseService getBaseService() {
        return baseService;
    }

    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }
}
