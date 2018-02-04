package com.xuechen.qdenv.contrallor;

import com.alibaba.fastjson.JSON;
import com.wondersgroup.framwork.dao.bo.Page;
import com.xuechen.qdenv.bo.Bz04;
import com.xuechen.qdenv.dto.Bz04Dto;
import com.xuechen.qdenv.service.QdenvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * "标准控制器"
 */
@Controller
@RequestMapping("/work")
public class BzContrallor {
    public QdenvService getQdenvService() {
        return qdenvService;
    }

    public void setQdenvService(QdenvService qdenvService) {
        this.qdenvService = qdenvService;
    }
    @Autowired
    private QdenvService qdenvService;


    @RequestMapping("/f100601/index")
    public String index_f100601(){
        return "/WEB-INF/page/f1006/f100601/index";
    }
    @RequestMapping("/f100602/index")
    public String index_f100602(){
        return "/WEB-INF/page/f1006/f100602/index";
    }
    @RequestMapping("/f100603/index")
    public String index_f100603(){
        return "/WEB-INF/page/f1006/f100603/index";
    }
    @RequestMapping("/f100601/loadHangyeAdd")
    public String loadHangyeAdd(){
        return "/WEB-INF/page/f1006/f100601/hangyeAdd";
    }

    /**
     * 分条件查询行业，分页
     * @param page
     * @return
     */
    @RequestMapping(value="/f100601/queryHangye",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryHangye(Page page){
        this.qdenvService.queryBz04(page,new Bz04Dto());
        return JSON.toJSONStringWithDateFormat(page, "yyyy-MM-dd HH:mm:ss.SSS");
    }

    /**
     * 保存行业
     * @param bz04
     * @return
     */
    @RequestMapping(value="/f100601/saveHangye",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String saveHangye(Bz04 bz04){
        bz04.setAae016("1");
        this.qdenvService.saveBz04(bz04);
        return  JSON.toJSONString(bz04);
    }

    /**
     * 修改行业
     * @param bz04
     * @return
     */
    @RequestMapping(value="/f100601/updateHangye",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String updateHangye(Bz04 bz04){
        this.qdenvService.updateBz04(bz04);
        return  JSON.toJSONString(bz04);
    }
}
