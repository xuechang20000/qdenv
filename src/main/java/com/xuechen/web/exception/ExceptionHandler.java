package com.xuechen.web.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ExceptionHandler implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("ex", ex);
        // 根据不同错误转向不同页面
        if(ex instanceof BusinessException) {
            return new ModelAndView("/error/busiException", model);
        }else {
            System.out.println(ex.getMessage());
            return new ModelAndView("/error/404", model);
        }
    }
}
