package com.xuechen.web.service;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import java.io.IOException;

public interface BaseService {
    public void exportExcel(ServletOutputStream outputStream, ServletContext context, String header, String jsonData) throws IOException;
}
