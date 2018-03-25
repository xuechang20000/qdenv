package com.xuechen.qdenv.contrallor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wondersgroup.framwork.dao.CommonJdbcUtils;
import com.wondersgroup.framwork.dao.bo.Page;
import com.xuechen.qdenv.bo.*;
import com.xuechen.qdenv.dto.*;
import com.xuechen.qdenv.service.QdenvService;
import com.xuechen.web.bo.AppNoticeAttachment;
import com.xuechen.web.dto.AppUserDTO;
import com.xuechen.web.utils.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    @RequestMapping("/f100202/index")
    public String index_f100202(){
        return "/WEB-INF/page/f1002/f100202/index";
    }
    @RequestMapping("/f100204/index")
    public String index_f100204(){
        return "/WEB-INF/page/f1002/f100204/index";
    }
    @RequestMapping("/f100203/index")
    public String index_f100203(){
        return "/WEB-INF/page/f1002/f100203/index";
    }
    @RequestMapping("/f100202/loadDO_1")
    public String index_load_do_1(){
        return "/WEB-INF/page/f1002/f100202/DO_1";
    }
    @RequestMapping("/f100202/loadDO_2")
    public String index_load_do_2(){
        return "/WEB-INF/page/f1002/f100202/DO_2";
    }
    @RequestMapping("/f100202/loadDO_3")
    public String index_load_do_3(){
        return "/WEB-INF/page/f1002/f100202/DO_3";
    }
    @RequestMapping("/f100202/loadDO_4")
    public String index_load_do_4(){
        return "/WEB-INF/page/f1002/f100202/DO_4";
    }
    @RequestMapping("/f100202/loadDO_5")
    public String index_load_do_5(){
        return "/WEB-INF/page/f1002/f100202/DO_5";
    }
    @RequestMapping("/f100202/loadDO_14")
    public String index_load_do_14(){
        return "/WEB-INF/page/f1002/f100202/DO_14";
    }
    @RequestMapping("/f100202/loadDO_7")
    public String index_load_do_7(Wt02Dto wt02Dto,HttpServletRequest request){
        Wt02Dto wt02Dto1=this.qdenvService.queryWt02Report(wt02Dto);
        request.setAttribute("dto",wt02Dto1);
        return "/WEB-INF/page/f1002/f100202/DO_7";
    }
    @RequestMapping("/f100202/loadDO_8")
    public String index_load_do_8(Wt02Dto wt02Dto,HttpServletRequest request){
        Wt02Dto wt02Dto1=this.qdenvService.queryWt02Report(wt02Dto);
        request.setAttribute("dto",wt02Dto1);
        return "/WEB-INF/page/f1002/f100202/DO_8";
    }
    @RequestMapping("/f100202/loadDO_6")
    public String index_load_do_6(){
        return "/WEB-INF/page/f1002/f100202/DO_6";
    }
    @RequestMapping("/f100202/loadWt03")
    public String index_loadWt03(){
        return "/WEB-INF/page/f1002/f100202/wt03";
    }
    @RequestMapping("/f100202/loadPhotos")
    public String index_loadPhotos(){
        return "/WEB-INF/page/f1002/f100202/photos";
    }
    @RequestMapping(value="/f100201/getWat016",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getWat016(String wat015){
        String wat016=this.qdenvService.getWat016(wat015);
        if (wat016.equals("0")) wat016="1";
        return wat016;
    }
    @RequestMapping(value="/f100201/saveWtAttach",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String saveWtAttach(Wt01Dto dto){
        Wt01 wt01=this.qdenvService.saveWt(dto);
        return JSON.toJSONString(wt01);
    }
    @RequestMapping(value="/f100201/saveWt",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String saveWt(Wt01Dto dto){
        List<Wt02Dto> wt02Dtos=JSONObject.parseArray(dto.getJson1(),Wt02Dto.class);
        List<Wt03Dto> wt03Dtos=JSONObject.parseArray(dto.getJson2(),Wt03Dto.class);
        Wt01 wt01=this.qdenvService.saveWt(dto,wt02Dtos,wt03Dtos);
        return JSON.toJSONString(wt01);
    }
    @RequestMapping(value="/f100201/saveWt02",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String saveWt02(Wt01Dto dto){
        List<Wt02Dto> wt02Dtos=JSONObject.parseArray(dto.getJson1(),Wt02Dto.class);
        this.qdenvService.saveWt02(wt02Dtos);
        return JSON.toJSONString(wt02Dtos);
    }
    @RequestMapping(value="/f100201/queryWt",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryWt(Page page,Wt01Dto wt01Dto){
        this.qdenvService.queryWt(page,wt01Dto);
        return JSON.toJSONStringWithDateFormat(page, "yyyy-MM-dd HH:mm:ss.SSS");
    }
    @RequestMapping(value="/f100201/queryWtList",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryWtList(Wt01Dto wt01Dto){
        List<Wt01Dto> wt01Dtos=this.qdenvService.queryWtList(wt01Dto);
        return JSON.toJSONStringWithDateFormat(wt01Dtos, "yyyy-MM-dd HH:mm:ss.SSS");
    }
    @RequestMapping(value="/f100201/queryWt02",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryWt02(Wt02Dto wt02Dto){
        List<Wt02Dto> wt02Dtos=this.qdenvService.queryWt02(wt02Dto);
        return JSON.toJSONStringWithDateFormat(wt02Dtos, "yyyy-MM-dd HH:mm:ss.SSS");
    }
    @RequestMapping(value="/f100201/queryWt03",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryWt03(Wt03Dto wt03Dto){
        List<Wt03Dto> wt03Dtos=this.qdenvService.queryWt03(wt03Dto);
        return JSON.toJSONStringWithDateFormat(wt03Dtos, "yyyy-MM-dd HH:mm:ss.SSS");
    }
    @RequestMapping(value="/f100201/queryWt06",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryWt06(String isPermission){
        List<Wt06Dto> wt06Dtos=this.qdenvService.queryWt06(true);
        return JSON.toJSONStringWithDateFormat(wt06Dtos, "yyyy-MM-dd HH:mm:ss.SSS");
    }
    @RequestMapping(value="/f100201/updateWt03",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String updateWt03(String wt03s){
        List<Wt03Dto> wt03Dtos=JSONObject.parseArray(wt03s,Wt03Dto.class);
        this.qdenvService.updateWt03(wt03Dtos);
        return JSON.toJSONStringWithDateFormat(wt03Dtos, "yyyy-MM-dd HH:mm:ss.SSS");
    }

    /**
     * 查询人员分配列表
     * @param wat001
     * @return
     */
    @RequestMapping(value="/f100201/queryWt08ListByWat001",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryWt08ListByWat001(String wat001){
        if (wat001==null) return "";
        List<Wt08Dto> wt08Dtos= this.qdenvService.queryWt08ByWat001(Integer.valueOf(wat001));

        return JSON.toJSONStringWithDateFormat(wt08Dtos, "yyyy-MM-dd HH:mm:ss.SSS");
    }

    /**
     * 保存人员分配列表
     * @param wt01Dto
     * @return
     */
    @RequestMapping(value="/f100201/saveWt08List",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String saveWt08List(Wt01Dto wt01Dto ){
        if (wt01Dto.getJson1()==null) return "";
        String[] strs=wt01Dto.getJson1().split(",");
        Wt08 wt08=null;
        List<Wt08> wt08s=new ArrayList<Wt08>(strs.length);
        AppUserDTO appUserDTO=(AppUserDTO)SecurityUtils.getSubject().getSession().getAttribute("user");
        for (String userid:strs){
            wt08=new Wt08();
            wt08.setWat001(wt01Dto.getWat001());
            wt08.setAae013(wt01Dto.getAae013());
            wt08.setWdt004(new Date());
            wt08.setWdt005(appUserDTO.getUserId());
            wt08.setUserid(Integer.valueOf(userid));
            wt08s.add(wt08);
        }
        this.qdenvService.saveWt08List(wt01Dto,wt08s);
        return JSON.toJSONStringWithDateFormat(wt08s, "yyyy-MM-dd HH:mm:ss.SSS");
    }

    /**
     * 跳转下一步（提交）
     * @param wt01Dto
     * @return
     */
    @RequestMapping(value="/f100201/saveNextStep",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String saveNextStep(Wt01Dto wt01Dto ){
        Wt01Dto dto=this.qdenvService.saveNextProcess(wt01Dto);
        return JSON.toJSONStringWithDateFormat(dto, "yyyy-MM-dd HH:mm:ss.SSS");
    }
    /**
     * 跳转上一步（退回）
     * @param wt01Dto
     * @return
     */
    @RequestMapping(value="/f100201/savePreStep",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String savePreStep(Wt01Dto wt01Dto ){
        Wt01Dto dto=this.qdenvService.savePreProcess(wt01Dto);
        return JSON.toJSONStringWithDateFormat(dto, "yyyy-MM-dd HH:mm:ss.SSS");
    }
    @RequestMapping(value = "/f100201/uploadWt03Photo",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String uploadWt03Photo(HttpServletRequest request,String wct001){
        Map map= FileUtils.uploadFilesByType(request,"COLL");
        AppUserDTO user = (AppUserDTO)SecurityUtils.getSubject().getSession().getAttribute("user");
        Wp01 wp01=new Wp01();
        wp01.setWtp004(new Date());
        wp01.setWtp007((String)map.get("fileExtName"));
        wp01.setWtp006((String)map.get("fileName"));
        wp01.setWtp005((String)map.get("filePath"));
        wp01.setWtp002("COLL");
        wp01.setUserid(user.getUserId());
        wp01.setWtp003(wct001);
        CommonJdbcUtils.insert(wp01);
        Wt03 wt03=new Wt03();
        wt03.setWct001(Integer.valueOf(wct001));
        wt03.setWtp001(wp01.getWtp001());
        CommonJdbcUtils.updateSelect(wt03);
        return map.get("filePath").toString();
    }
    /**
     * 下载附件
     * @param wp01Dto
     * @return
     */
    @RequestMapping(value="/f100201/downLoadAttachment",produces = "application/json; charset=utf-8")
    public void downloadWp01List(HttpServletRequest request, HttpServletResponse response,Wp01Dto wp01Dto ){
        List<Wp01Dto> wp01Dtos=this.qdenvService.queryWp01List(wp01Dto);
        if (wp01Dtos!=null&&wp01Dtos.size()>0)
       FileUtils.downLoadFile(request,response,wp01Dtos.get(0).getWtp005());
    }
    /**
     * 查询附件
     * @param wp01Dto
     * @return
     */
    @RequestMapping(value="/f100201/queryWp01List",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryWp01List(Wp01Dto wp01Dto ){
        List<Wp01Dto> wp01Dtos=this.qdenvService.queryWp01List(wp01Dto);
        return JSON.toJSONStringWithDateFormat(wp01Dtos, "yyyy-MM-dd HH:mm:ss.SSS");
    }

}
