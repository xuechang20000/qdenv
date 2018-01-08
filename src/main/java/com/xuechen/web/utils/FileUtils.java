package com.xuechen.web.utils;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileUtils {

    /**
     * 批量上传
     * @return
     */
    public static Map uploadFiles(HttpServletRequest request, String filePath){
        ShiroHttpServletRequest shiroRequest = (ShiroHttpServletRequest) request;

        Map map =new HashMap();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=
                new CommonsMultipartResolver(request.getSession().getServletContext());
        //当前时间文件名
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multipartRequest = multipartResolver.resolveMultipart((HttpServletRequest) shiroRequest.getRequest());
            //获取multiRequest 中所有的文件名
            Iterator iter=multipartRequest.getFileNames();

            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multipartRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    String fileExt=getFileExt(file.getOriginalFilename());
                    String path=filePath+sdf.format(new Date())+getRandm()+"."+fileExt;
                    //上传
                    try {
                        file.transferTo(new File(path));
                        map.put("filePath",path);
                        map.put("fileExtName",fileExt);
                        map.put("fileName",file.getOriginalFilename());
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }

            }

        }
        return map;
    }

    public static void downLoadFile(HttpServletRequest request,HttpServletResponse response,String filePath){
        File file=new File(filePath);
        InputStream inputStream;
        try {
            //设置文件MIME类型
            response.setContentType(request.getSession().getServletContext().getMimeType(filePath));
            //设置Content-Disposition
            response.setHeader("Content-Disposition", "attachment;filename="+filePath);
            inputStream=new BufferedInputStream(new FileInputStream(file));
            OutputStream os= new BufferedOutputStream(response.getOutputStream());
            //写文件
            int b;
            while((b=inputStream.read())!= -1)
            {
                os.write(b);
            }
            os.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getFileExt(String fileName){
        if (fileName!=null&&fileName.indexOf(".")>0){
            return fileName.substring(fileName.indexOf(".")+1);
        }
        return "";
    }
    public static int getRandm(){
        Random random=new Random();
        return  random.nextInt(1000);
    }
}
