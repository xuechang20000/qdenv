package com.xuechen.qdenv.contrallor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wondersgroup.framwork.dao.bo.Page;
import com.xuechen.qdenv.bo.Bz02;
import com.xuechen.qdenv.bo.Bz03;
import com.xuechen.qdenv.bo.Bz04;
import com.xuechen.qdenv.bo.Wt01;
import com.xuechen.qdenv.dto.*;
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

    @RequestMapping(value="/f100201/getWat016",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getWat016(String wat015){
        String wat016=this.qdenvService.getWat016(wat015);
        if (wat016.equals("0")) wat016="1";
        return wat016;
    }
    @RequestMapping(value="/f100201/saveWt",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String saveWt(Wt01Dto dto){
        List<Wt02Dto> wt02Dtos=JSONObject.parseArray(dto.getJson1(),Wt02Dto.class);
        List<Wt03Dto> wt03Dtos=JSONObject.parseArray(dto.getJson2(),Wt03Dto.class);
        Wt01 wt01=this.qdenvService.saveWt(dto,wt02Dtos,wt03Dtos);
        return JSON.toJSONString(wt01);
    }
}
