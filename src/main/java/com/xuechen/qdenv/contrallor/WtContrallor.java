package com.xuechen.qdenv.contrallor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wondersgroup.framwork.dao.bo.Page;
import com.xuechen.qdenv.bo.Bz02;
import com.xuechen.qdenv.bo.Bz03;
import com.xuechen.qdenv.bo.Bz04;
import com.xuechen.qdenv.dto.Bz01Dto;
import com.xuechen.qdenv.dto.Bz02Dto;
import com.xuechen.qdenv.dto.Bz03Dto;
import com.xuechen.qdenv.dto.Bz04Dto;
import com.xuechen.qdenv.service.QdenvService;
import com.xuechen.web.dto.AppUserDTO;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * "标准控制器"
 */
@Controller
@RequestMapping("/work")
public class WtContrallor {
    public QdenvService getQdenvService() {
        return qdenvService;
    }

    public void setQdenvService(QdenvService qdenvService) {
        this.qdenvService = qdenvService;
    }
    @Autowired
    private QdenvService qdenvService;


    @RequestMapping("/f100201/index")
    public String index_f100201(){
        return "/WEB-INF/page/f1002/f100201/index";
    }

}
