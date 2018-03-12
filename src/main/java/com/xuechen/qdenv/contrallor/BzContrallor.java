package com.xuechen.qdenv.contrallor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wondersgroup.framwork.dao.CommonJdbcUtils;
import com.wondersgroup.framwork.dao.bo.Page;
import com.xuechen.qdenv.bo.Bz02;
import com.xuechen.qdenv.bo.Bz03;
import com.xuechen.qdenv.bo.Bz04;
import com.xuechen.qdenv.bo.Bz06;
import com.xuechen.qdenv.dto.*;
import com.xuechen.qdenv.service.QdenvService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @RequestMapping("/f100604/index")
    public String index_f100604(){
        return "/WEB-INF/page/f1006/f100604/index";
    }
    @RequestMapping("/f100601/loadHangyeAdd")
    public String loadHangyeAdd(){
        return "/WEB-INF/page/f1006/f100601/hangyeAdd";
    }
    @RequestMapping("/f100602/loadBiaoZhunAdd")
    public String loadBiaoZhunAdd(){
        return "/WEB-INF/page/f1006/f100602/biaoZhunAdd";
    }
    @RequestMapping("/f100604/loadInstrumentAdd")
    public String loadInstrumentAdd(){
        return "/WEB-INF/page/f1006/f100604/instrumentAdd";
    }
    @RequestMapping("/f100604/loadInstrumentEdit")
    public String loadInstrumentEdit(){
        return "/WEB-INF/page/f1006/f100604/instrumentEdit";
    }
    @RequestMapping("/f100602/loadBiaoZhunCopy")
    public String loadBiaoZhunCopy( Bz01Dto bz01Dto,HttpServletRequest request){
        List<Bz01Dto> list=this.qdenvService.queryBz01(bz01Dto);
        if (list.size()>0)
            request.setAttribute("dto",list.get(0));
        return "/WEB-INF/page/f1006/f100602/biaoZhunCopy";
    }
    @RequestMapping("/f100602/loadBiaoZhunDelete")
    public String loadBiaoZhunDelete( Bz01Dto bz01Dto,HttpServletRequest request){
        List<Bz01Dto> list=this.qdenvService.queryBz01(bz01Dto);
        if (list.size()>0)
            request.setAttribute("dto",list.get(0));
        return "/WEB-INF/page/f1006/f100602/biaoZhunDelete";
    }
    @RequestMapping("/f100602/loadBiaoZhunEdit")
    public String loadBiaoZhunEdit(Bz01Dto bz01Dto, HttpServletRequest request){
        List<Bz01Dto> list=this.qdenvService.queryBz01(bz01Dto);
        if (list.size()>0)
            request.setAttribute("dto",list.get(0));
        return "/WEB-INF/page/f1006/f100602/biaoZhunEdit";
    }
    @RequestMapping("/f100603/loadZuheAdd")
    public String loadZuheAdd(Bz01Dto bz01Dto, HttpServletRequest request){
        List<Bz01Dto> list=this.qdenvService.queryBz01(bz01Dto);
        if (list.size()>0)
            request.setAttribute("dto",list.get(0));
        return "/WEB-INF/page/f1006/f100603/zuheAdd";
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
     * 分条件查询行业
     * @param bz04Dto
     * @return
     */
    @RequestMapping(value="/f100601/queryHangyeList",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryHangyeList(Bz04Dto bz04Dto){
        List<Bz04Dto> bz04DtoList=this.qdenvService.queryBz04(bz04Dto);
        return JSON.toJSONStringWithDateFormat(bz04DtoList, "yyyy-MM-dd HH:mm:ss.SSS");
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

    /**
     * 查询标准分页
     * @param page
     * @return
     */
    @RequestMapping(value="/f100602/queryBiaozhun",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryBiaozhun(Page page,Bz01Dto dto){
        this.qdenvService.queryBz01(page,dto);
        return JSON.toJSONStringWithDateFormat(page, "yyyy-MM-dd HH:mm:ss.SSS");
    }
    /**
     * 查询标准list
     * @param page
     * @return
     */
    @RequestMapping(value="/f100602/queryBiaozhunList",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryBiaozhunList(Page page,Bz01Dto dto){
        List<Bz01Dto> bz01Dtos=this.qdenvService.queryBz01(dto);
        return JSON.toJSONStringWithDateFormat(bz01Dtos, "yyyy-MM-dd HH:mm:ss.SSS");
    }
    /**
     * 保存标准
     * @param bz01Dto
     * @return
     */
    @RequestMapping(value="/f100602/saveBiaozhun",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String saveBiaozhun(Bz01Dto bz01Dto){
        if (bz01Dto.getAae016()==null) bz01Dto.setAae016("1");
        bz01Dto.setBbz006(new Date());
        if (bz01Dto.getBhz001ss()!=null)
            bz01Dto.setBhz001s(bz01Dto.getBhz001ss().split(","));
        this.qdenvService.saveBz01(bz01Dto);
        return  JSON.toJSONStringWithDateFormat(bz01Dto, "yyyy-MM-dd HH:mm:ss.SSS");
    }

    /**
     * 复制标准
     * @param bz01Dto
     * @return
     */
    @RequestMapping(value="/f100602/copyBiaozhun",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String copyBiaozhun(Bz01Dto bz01Dto){
        if (bz01Dto.getAae016()==null) bz01Dto.setAae016("1");
        bz01Dto.setBbz006(new Date());
        if (bz01Dto.getBhz001ss()!=null)
            bz01Dto.setBhz001s(bz01Dto.getBhz001ss().split(","));
        this.qdenvService.CopyBz01(bz01Dto);
        return  JSON.toJSONStringWithDateFormat(bz01Dto, "yyyy-MM-dd HH:mm:ss.SSS");
    }
    /**
     * 查询检测项目
     * @param page
     * @return
     */
    @RequestMapping(value="/f100602/queryXiangMu",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryXiangMu(Page page, Bz02Dto dto){
        this.qdenvService.queryBz02(page,dto);
        return JSON.toJSONStringWithDateFormat(page, "yyyy-MM-dd HH:mm:ss.SSS");
    }
    /**
     * 查询检测项目
     * @param dto
     * @return
     */
    @RequestMapping(value="/f100602/queryXiangMuList",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryXiangMuList( Bz02Dto dto){
        List<Bz02Dto> bz02Dtos=this.qdenvService.queryBz02(dto);
        return JSON.toJSONStringWithDateFormat(bz02Dtos, "yyyy-MM-dd HH:mm:ss.SSS");
    }
    /**
     * 保存检测项目
     * @param json
     * @return
     */
    @RequestMapping(value="/f100602/saveXiangMu",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String saveXiangMu(String json){
        List<Bz02Dto> bz02Dtos= JSONObject.parseArray(json,Bz02Dto.class);
        List<Bz02> bz02s=new ArrayList<Bz02>();
        Bz02 bz02=null;
        for (Bz02Dto bz02Dto:bz02Dtos){
            bz02=new Bz02();
            BeanUtils.copyProperties(bz02Dto,bz02);
            if (bz02Dto.getBcz003().equals("5")){//如果是范围
                String[] bcz0045=bz02Dto.getBcz0045().split("~");
                bz02.setBcz004(Double.valueOf(bcz0045[0]));
                bz02.setBcz005(Double.valueOf(bcz0045[1]));
            }else {
                bz02.setBcz004(Double.valueOf(bz02Dto.getBcz0045()));
            }
            bz02.setBcz007(bz02Dto.getRowIndex());
            bz02s.add(bz02);
        }
        this.qdenvService.saveBz02(bz02s);
        return JSON.toJSONStringWithDateFormat(bz02s, "yyyy-MM-dd HH:mm:ss.SSS");
    }

    @RequestMapping(value="/f100603/saveFenzu",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String saveFenzu(Bz03Dto bz03Dto){
        Bz03 bz03=this.qdenvService.saveBz03(bz03Dto);
        return JSON.toJSONStringWithDateFormat(bz03, "yyyy-MM-dd HH:mm:ss.SSS");
    }
    @RequestMapping(value="/f100603/deleteFenzu",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteFenzu(Bz03Dto bz03Dto){
        this.qdenvService.deleteBz03(bz03Dto);
        return "";
    }
    @RequestMapping(value="/f100603/queryFenzu",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryFenzu(Page page,Bz03Dto bz03Dto){
        this.qdenvService.queryBz03(page,bz03Dto);
        return JSON.toJSONStringWithDateFormat(page, "yyyy-MM-dd HH:mm:ss.SSS");
    }
    @RequestMapping(value="/f100603/queryFenzuList",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryFenzuList(Bz03Dto bz03Dto){
        List<Bz03Dto> bz03Dtos=this.qdenvService.queryBz03List(bz03Dto);
        return JSON.toJSONStringWithDateFormat(bz03Dtos, "yyyy-MM-dd HH:mm:ss.SSS");
    }
    @RequestMapping(value="/f100604/queryBz06",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryBz06(Page page,Bz06Dto bz06Dto){
        this.qdenvService.queryBz06(page,bz06Dto);
        return JSON.toJSONStringWithDateFormat(page, "yyyy-MM-dd HH:mm:ss.SSS");
    }
    @RequestMapping(value="/f100604/queryBz06List",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryBz06List(Bz06Dto bz06Dto){
        List<Bz06Dto> bz06Dtos=this.qdenvService.queryBz06List(bz06Dto);
        return JSON.toJSONStringWithDateFormat(bz06Dtos, "yyyy-MM-dd HH:mm:ss.SSS");
    }
    @RequestMapping(value="/f100604/saveOrUpdateBz06",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String saveOrUpdateBz06(Bz06Dto bz06Dto){
        Bz06 bz06=this.qdenvService.saveOrUpdateBz06(bz06Dto);
        return JSON.toJSONStringWithDateFormat(bz06, "yyyy-MM-dd HH:mm:ss.SSS");
    }
}
