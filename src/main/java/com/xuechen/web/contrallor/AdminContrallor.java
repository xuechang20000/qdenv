package com.xuechen.web.contrallor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuechen.core.utils.Md5Utils;
import com.xuechen.web.bo.*;
import com.xuechen.web.dto.AppNoticeDTO;
import com.xuechen.web.dto.AppRoleDTO;
import com.xuechen.web.dto.AppUserDTO;
import com.xuechen.web.dto.Page;
import com.xuechen.web.exception.BusinessException;
import com.xuechen.web.service.AdminService;
import com.xuechen.web.service.UserService;
import com.xuechen.web.utils.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminContrallor {
        @Autowired
        private AdminService adminService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
        private UserService userService;
        public AdminService getAdminService() {
            return adminService;
        }

        public void setAdminService(AdminService adminService) {
            this.adminService = adminService;
        }

        @RequestMapping("/f100101/index")
        public String index_f100101(){
            return "/WEB-INF/page/f1001/f100101/index";
        }
        @RequestMapping("/f100102/index")
        public String index_f100102(){
            return "/WEB-INF/page/f1001/f100102/index";
        }
        @RequestMapping("/f100103/index")
        public String index_f100103(){
            return "/WEB-INF/page/f1001/f100103/index";
        }
        @RequestMapping("/f100201/index")
        public String index_f100201(){
            return "/WEB-INF/page/f1002/f100201/index";
        }
        @RequestMapping("/f100401/index")
        public String index_f100401(){
            return "/WEB-INF/page/f1004/f100401/index";
        }
        @RequestMapping("/f100402/index")
        public String index_f100402(){
            return "/WEB-INF/page/f1004/f100402/index";
        }
        @RequestMapping("/f1005/index")
        public String index_f1005(){
            return "/WEB-INF/page/f1005/index";
        }
        @RequestMapping("/f1005/loadUpload")
        public String index_loadUpload(){
            return "/WEB-INF/page/f1005/upload";
        }
        @RequestMapping("/loadUserAdd")
        public String loadUserAdd(){
            return "/WEB-INF/page/f1001/f100101/userAdd";
        }
        @RequestMapping("/loadDictAdd")
        public String loadDictAdd(){
            return "/WEB-INF/page/f1001/f100103/dictAdd";
        }
        @RequestMapping("/loadDictDetailAdd")
        public String loadDictDetailAdd(){
            return "/WEB-INF/page/f1001/f100103/dictDetailAdd";
        }
        @RequestMapping(value="/queryAllUser",produces = "application/json; charset=utf-8")
        @ResponseBody
        public String queryAllUser(Page page, AppUser appUser){
            PageHelper.startPage(page.getPageIndex()+1,page.getPageSize());

            List<AppUserDTO> appUserList=this.adminService.queryAllUser(appUser);

            PageInfo<AppUserDTO> pageInfo = new PageInfo<AppUserDTO>(appUserList);
            page.setTotal(pageInfo.getTotal());
            page.setData(appUserList);
            return JSON.toJSONStringWithDateFormat(page, "yyyy-MM-dd HH:mm:ss.SSS");
        }
        @RequestMapping(value="/queryAllRole",produces = "application/json; charset=utf-8")
        @ResponseBody
        public String queryAllRole(Integer roleId){
            List<AppRole> appRoles=this.adminService.queryAllRole(roleId);
            return JSONObject.toJSONString(appRoles);
        }
        @RequestMapping("/saveAppUserRole")
        @ResponseBody
        public String saveAppUserRole(String loginname,String name,String sex,String roles){
            this.adminService.userAdd(loginname,name,sex,roles);
            return  "";
        }
        @RequestMapping("/editAppUserRole")
        @ResponseBody
        public String editAppUserRole(Integer userId,String loginname,String name,String sex,String roles){
            this.adminService.userEdit(userId,loginname,name,sex,roles);
            return  "";
        }
        @RequestMapping("/deleteUser")
        @ResponseBody
        public String deleteUser(Integer userid){
            this.adminService.userDel(userid);
            return  "";
        }
        @RequestMapping("/loadEditUserInfo")
        public ModelAndView loadEditUserInfo(AppUserDTO appUserDTO){
            appUserDTO=this.adminService.queryUserInfo(appUserDTO.getUserId());
            ModelAndView mav=new ModelAndView("/WEB-INF/page/f1001/f100101/userEdit");
            mav.addObject("dtoJson",JSONObject.toJSON(appUserDTO).toString());
            return mav;
        }
    @RequestMapping("/updatePassword")
    @ResponseBody
    public String updatePassword(String password,String newPassword){
        AppUserDTO appUserDTO=(AppUserDTO)SecurityUtils.getSubject().getSession().getAttribute("user");
        if(!Md5Utils.MD5Code(password).equals(appUserDTO.getPassword()))
            throw new BusinessException("原密码不正确！");
        AppUser appUser=new AppUser();
        appUser.setUserId(appUserDTO.getUserId());
        appUser.setPassword(Md5Utils.MD5Code(newPassword));
        this.userService.updatePassword(appUser);
        return "";
    }
    @RequestMapping("/loadUpdatePassword")
    public String loadUpdatePassword(){
        return "/WEB-INF/page/f1001/f100101/userUpdatePassword";
    }
        @RequestMapping(value = "/queryAllRoleList",produces = "application/json; charset=utf-8")
        @ResponseBody
        public  String queryAllRoleList(Page page,Integer roleId){
            PageHelper.startPage(page.getPageIndex()+1,page.getPageSize());
            List<AppRole> appRoleList=this.adminService.queryAllRole(roleId);
            PageInfo<AppRole> pageInfo = new PageInfo<AppRole>(appRoleList);
            Page p=new Page(pageInfo.getTotal(),appRoleList);
            return JSONObject.toJSONString(p);
        }
        @RequestMapping("/queryAllRoleByRoleID")
        @ResponseBody
        public String queryAllRoleByRoleID(AppRole appRole){
            List<AppRoleDTO> appRoleDTOS=this.adminService.queryAppRoleDTO(appRole);
            if (appRoleDTOS!=null&&appRoleDTOS.size()>0)
                return JSON.toJSONString(appRoleDTOS.get(0));
            else
                return "" ;
        }

        @RequestMapping("/loadEditRoleInfoPage")
        public ModelAndView loadEditRoleInfoPage(AppRole appRole) {
            ModelAndView mav=new ModelAndView("/WEB-INF/page/f1001/f100102/roleEdit");

            String dtoJson=queryAllRoleByRoleID(appRole);
            mav.addObject("dtoJson",dtoJson);
            return mav;
        }
        @RequestMapping(value = "/queryAllAppMenu",produces = "application/json; charset=utf-8")
        @ResponseBody
        public String queryAllAppMenu(AppMenu appMenu){
            List<AppMenu> appMenuList=this.adminService.queryAllAppMenu(appMenu);
            return JSONObject.toJSONString(appMenuList);
        }
        @RequestMapping(value = "/queryAllAppResource",produces = "application/json; charset=utf-8")
        @ResponseBody
        public String queryAllAppResource(Page page,AppResource appResource){
            PageHelper.startPage(page.getPageIndex()+1,page.getPageSize());
            List<AppResource> appResourceList=this.adminService.queryAllAppResource(appResource);
            PageInfo<AppResource> pageInfo = new PageInfo<AppResource>(appResourceList);
            Page p=new Page(pageInfo.getTotal(),appResourceList);
            return JSONObject.toJSONString(p);
        }
        @RequestMapping("/updateAppRolePermission")
        @ResponseBody
        public String updateAppRolePermission(String menus,String resources,Integer roleId){
            List<AppResource> appResources=new ArrayList<AppResource>();
            if(resources.length()>0)
                appResources=JSONObject.parseArray(resources,AppResource.class);
            this.adminService.updateAppRole(roleId,menus,appResources);
            return "";
        }
        @RequestMapping(value = "/queryAppDicts",produces = "application/json; charset=utf-8")
        @ResponseBody
        public String queryAppDicts(Page page,AppDict appDict){
            PageHelper.startPage(page.getPageIndex()+1,page.getPageSize());
            List<AppDict> appDictList=this.adminService.queryAppDicts(appDict);
            PageInfo<AppDict> pageInfo = new PageInfo<AppDict>(appDictList);
            Page p=new Page(pageInfo.getTotal(),appDictList);
            return JSONObject.toJSONString(p);
        }
        @RequestMapping(value = "/queryAppDictDetails",produces = "application/json; charset=utf-8")
        @ResponseBody
        public String queryAppDictDetails(Page page,AppDictDetail appDictDetail){
            PageHelper.startPage(page.getPageIndex()+1,page.getPageSize());
            List<AppDictDetail> appDictDetails=this.adminService.queryAppDictDetails(appDictDetail);
            PageInfo<AppDictDetail> pageInfo = new PageInfo<AppDictDetail>(appDictDetails);
            Page p=new Page(pageInfo.getTotal(),appDictDetails);
            return JSONObject.toJSONString(p);
        }
        @RequestMapping(value = "/queryRenderedAppDictDetails",produces = "application/json; charset=utf-8")
        @ResponseBody
        public String queryRenderedAppDictDetails(AppDictDetail appDictDetail,HttpServletRequest request){
            ServletContext context=request.getSession().getServletContext();
            //List<AppDictDetail> appDictDetails=this.adminService.queryAppDictDetails(appDictDetail);
            List<AppDictDetail> appDictDetails=(List<AppDictDetail>)context.getAttribute(appDictDetail.getDictCode().toUpperCase());
            return JSONObject.toJSONString(appDictDetails);
        }
        /**
         * 添加字典
         * @param appDict
         * @param adds
         */
        @RequestMapping("/addAppDict")
        @ResponseBody
        public String addAppDict(AppDict appDict, String adds, HttpServletRequest request){
            List<AppDictDetail> appDictDetails=JSONObject.parseArray(adds,AppDictDetail.class);
            this.adminService.addAppDict(appDict,appDictDetails);
            this.adminService.refreashContext(request.getSession().getServletContext(),appDict.getDictCode());
            return "";
        }
        @RequestMapping("/addAppDictDetail")
        @ResponseBody
        public String addAppDictDetail(AppDictDetail appDictDetail, HttpServletRequest request){
            this.adminService.addAppDictDetail(appDictDetail.getDictCode(),appDictDetail);
            this.adminService.refreashContext(request.getSession().getServletContext(),appDictDetail.getDictCode());

            return "";
        }
        @RequestMapping("/updateAppDict")
        @ResponseBody
        public String updateAppDict(String appDicts,String status, HttpServletRequest request){
            List<AppDict> appDictList=JSONObject.parseArray(appDicts,AppDict.class);
            for (AppDict appDict:appDictList){
                if(status!=null) appDict.setStatus(status);
                this.adminService.updateAppDict(appDict);
                this.adminService.refreashContext(request.getSession().getServletContext(),appDict.getDictCode());
            }
            return "";
        }
        @RequestMapping("/updateAppDictDetail")
        @ResponseBody
        public String updateAppDictDetail(String appDictDetails,String status, HttpServletRequest request){
            List<AppDictDetail> appDictDetailList=JSONObject.parseArray(appDictDetails,AppDictDetail.class);
            for (AppDictDetail appDictDetail:appDictDetailList){
                if(status!=null) appDictDetail.setStatus(status);
                this.adminService.updateAppDictDetail(appDictDetail);
                this.adminService.refreashContext(request.getSession().getServletContext(),appDictDetail.getDictCode());
            }
            return "";
        }

    /**
     * 查询收件箱
     * @return
     */
    @RequestMapping(value = "/loadRecevieMail",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadRecevieMail(Page page,String noticeType,String noticeIsread){
            AppUserDTO appUserDTO= (AppUserDTO) SecurityUtils.getSubject().getSession().getAttribute("user");
            AppNoticeDTO appNotice=new AppNoticeDTO();
            appNotice.setNoticeType(noticeType);
            appNotice.setUserId(appUserDTO.getUserId());
            appNotice.setRemoved("0");
            if(noticeIsread!=null) appNotice.setNoticeIsread(noticeIsread);
            PageHelper.startPage(page.getPageIndex()+1,page.getPageSize());
            List<AppNoticeDTO> appNoticeDTOS=this.adminService.queryPreNotice(appNotice);
            PageInfo<AppNoticeDTO> pageInfo = new PageInfo<AppNoticeDTO>(appNoticeDTOS);
            Page p=new Page(pageInfo.getTotal(),appNoticeDTOS);
            return JSON.toJSONStringWithDateFormat(p, "yyyy-MM-dd HH:mm:ss.SSS");
        }
    /**
     * 查询发件箱
     * @return
     */
    @RequestMapping(value = "/loadSendMail",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadSendMail(Page page,String noticeType){
        AppUserDTO appUserDTO= (AppUserDTO) SecurityUtils.getSubject().getSession().getAttribute("user");
        AppNotice appNotice=new AppNotice();
        appNotice.setNoticeType(noticeType);
        appNotice.setUserId(appUserDTO.getUserId());
        PageHelper.startPage(page.getPageIndex()+1,page.getPageSize());
        List<AppNoticeDTO> appNoticeDTOS=this.adminService.queryNotices(appNotice);
        PageInfo<AppNoticeDTO> pageInfo = new PageInfo<AppNoticeDTO>(appNoticeDTOS);
        Page p=new Page(pageInfo.getTotal(),appNoticeDTOS);
        return  JSON.toJSONStringWithDateFormat(p, "yyyy-MM-dd HH:mm:ss.SSS");
    }
    @RequestMapping(value = "/uploadAttachMent",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String uploadAttachment(HttpServletRequest request,String id){
        Map map=FileUtils.uploadFiles(request,"E:\\springUpload\\");
        AppNoticeAttachment appNoticeAttachment=new AppNoticeAttachment();
        appNoticeAttachment.setCtime(new Date());
        appNoticeAttachment.setExtname((String)map.get("fileExtName"));
        appNoticeAttachment.setFilename((String)map.get("fileName"));
        appNoticeAttachment.setUrl((String)map.get("filePath"));
        appNoticeAttachment.setNoticeId(Integer.valueOf(id));
        this.adminService.saveAppNoticeAttachment(appNoticeAttachment);
        return map.get("filePath").toString();
    }
    @RequestMapping("/downLoadAttachment")
    public void downLoadAttachment(HttpServletRequest request, HttpServletResponse response, Integer attid){
        AppNoticeAttachment appNoticeAttachment=this.adminService.queryAppNoticeAttachentByid(attid);
        FileUtils.downLoadFile(request,response,appNoticeAttachment.getUrl());
    }
    @RequestMapping("/saveAppNotice")
    @ResponseBody
    public String saveAppNotice(AppNotice appNotice,String users){
        this.adminService.saveAppNotice(appNotice,users);
        return  JSON.toJSONString(appNotice);
    }
    @RequestMapping(value = "/queryAppNoticeAttachment",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryAppNoticeAttachment(Integer noticeId){
        List<AppNoticeAttachment> appNoticeAttachments=this.adminService.queryAppNoticeAttachment(noticeId);
        return  JSON.toJSONString(appNoticeAttachments);
    }
    @RequestMapping(value = "/queryAppNoticeById",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryAppNoticeById(Integer noticeId){
        AppNoticeDTO appNoticeDTO=new AppNoticeDTO();
        appNoticeDTO.setNoticeId(noticeId);
        List<AppNoticeDTO> appNoticeDTOS=this.adminService.queryNotices(appNoticeDTO);
        if (appNoticeDTOS.size()>0){
            return JSON.toJSONString(appNoticeDTOS.get(0));
        }
        return "";
    }
    @RequestMapping(value = "/deleteAppNoticeById",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteAppNoticeById(Integer noticeId){
        this.adminService.updateAppNotice(noticeId,"1");
        return "";
    }
    @RequestMapping("/f1005/loadDetail")
    public String index_detail(HttpServletRequest request,Integer noticeId,String v,String noticeType){
        AppNoticeDTO appNoticeDTO=new AppNoticeDTO();
        appNoticeDTO.setNoticeId(noticeId);
        List<AppNoticeDTO> appNoticeDTOS=this.adminService.selectAppNoticeResult(appNoticeDTO);
        if (appNoticeDTOS.size()>0){
           request.setAttribute("list",JSON.toJSONString(appNoticeDTOS.get(0)));
           request.setAttribute("isSend",v);
           if(noticeType==null) noticeType="2";
            request.setAttribute("noticeType",noticeType);
        }
        if("1".equals(noticeType))  return "/WEB-INF/page/f1004/f100402/detail";
        return "/WEB-INF/page/f1005/detail";
    }
    @RequestMapping("/updateAppNoticeUser")
    @ResponseBody
    public String updateAppNoticeUser(AppNoticeUser appNoticeUser){
        AppUserDTO appUserDTO= (AppUserDTO) SecurityUtils.getSubject().getSession().getAttribute("user");
        appNoticeUser.setUserId(appUserDTO.getUserId());
        appNoticeUser.setNoticeReadTime(new Date());
       this.adminService.updateAppNoticeUser(appNoticeUser);
       return "";
    }
}
