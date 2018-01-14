package com.xuechen.web.service.impl;


import com.xuechen.core.utils.Md5Utils;
import com.xuechen.web.bo.*;
import com.xuechen.web.dao.*;
import com.xuechen.web.dto.AppNoticeDTO;
import com.xuechen.web.dto.AppRoleDTO;
import com.xuechen.web.dto.AppUserDTO;
import com.xuechen.web.exception.BusinessException;
import com.xuechen.web.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.mybatis.generator.internal.util.StringUtility;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AppUserMapper appUserMapper;
    @Autowired
    private AppRoleMapper appRoleMapper;
    @Autowired
    private AppUserRoleMapper appUserRoleMapper;
    @Autowired
    private AppMenuMapper appMenuMapper;
    @Autowired
    private AppPermissionMapper appPermissionMapper;
    @Autowired
    private AppRolePermissionMapper appRolePermissionMapper;
    @Autowired
    private AppNoticeMapper appNoticeMapper;
    @Autowired
    private AppNoticeAttachmentMapper appNoticeAttachmentMapper;
    @Autowired
    private AppNoticeUserMapper appNoticeUserMapper;

    public AppNoticeMapper getAppNoticeMapper() {
        return appNoticeMapper;
    }

    public void setAppNoticeMapper(AppNoticeMapper appNoticeMapper) {
        this.appNoticeMapper = appNoticeMapper;
    }

    public AppNoticeAttachmentMapper getAppNoticeAttachmentMapper() {
        return appNoticeAttachmentMapper;
    }

    public void setAppNoticeAttachmentMapper(AppNoticeAttachmentMapper appNoticeAttachmentMapper) {
        this.appNoticeAttachmentMapper = appNoticeAttachmentMapper;
    }

    public AppNoticeUserMapper getAppNoticeUserMapper() {
        return appNoticeUserMapper;
    }

    public void setAppNoticeUserMapper(AppNoticeUserMapper appNoticeUserMapper) {
        this.appNoticeUserMapper = appNoticeUserMapper;
    }

    private AppRolePermissionMapper getAppRolePermissionMapper() {
        return appRolePermissionMapper;
    }

    public void setAppRolePermissionMapper(AppRolePermissionMapper appRolePermissionMapper) {
        this.appRolePermissionMapper = appRolePermissionMapper;
    }
    @Autowired
    private AppDictMapper appDictMapper;
    @Autowired
    private AppDictDetailMapper appDictDetailMapper;

    public AppDictMapper getAppDictMapper() {
        return appDictMapper;
    }

    public void setAppDictMapper(AppDictMapper appDictMapper) {
        this.appDictMapper = appDictMapper;
    }

    public AppDictDetailMapper getAppDictDetailMapper() {
        return appDictDetailMapper;
    }

    public void setAppDictDetailMapper(AppDictDetailMapper appDictDetailMapper) {
        this.appDictDetailMapper = appDictDetailMapper;
    }

    public AppPermissionMapper getAppPermissionMapper() {
        return appPermissionMapper;
    }

    public void setAppPermissionMapper(AppPermissionMapper appPermissionMapper) {
        this.appPermissionMapper = appPermissionMapper;
    }

    public AppMenuMapper getAppMenuMapper() {
        return appMenuMapper;
    }

    public void setAppMenuMapper(AppMenuMapper appMenuMapper) {
        this.appMenuMapper = appMenuMapper;
    }

    public AppResourceMapper getAppResourceMapper() {
        return appResourceMapper;
    }

    public void setAppResourceMapper(AppResourceMapper appResourceMapper) {
        this.appResourceMapper = appResourceMapper;
    }

    @Autowired

    private AppResourceMapper appResourceMapper;

    public AppAdminMapper getAppAdminMapper() {
        return appAdminMapper;
    }

    public void setAppAdminMapper(AppAdminMapper appAdminMapper) {
        this.appAdminMapper = appAdminMapper;
    }

    @Autowired
    private AppAdminMapper appAdminMapper;
    public AppRoleMapper getAppRoleMapper() {
        return appRoleMapper;
    }

    public void setAppRoleMapper(AppRoleMapper appRoleMapper) {
        this.appRoleMapper = appRoleMapper;
    }

    public AppUserRoleMapper getAppUserRoleMapper() {
        return appUserRoleMapper;
    }

    public void setAppUserRoleMapper(AppUserRoleMapper appUserRoleMapper) {
        this.appUserRoleMapper = appUserRoleMapper;
    }

    public AppUserMapper getAppUserMapper() {
        return appUserMapper;
    }

    public void setAppUserMapper(AppUserMapper appUserMapper) {
        this.appUserMapper = appUserMapper;
    }

    public List<AppUserDTO> queryAllUser(AppUser appUser){
        AppUserExample appUserExample=new AppUserExample();
        AppUserExample.Criteria criteria=appUserExample.createCriteria();
        if(appUser!=null) {
            if(appUser.getName()!=null)criteria.andNameLike(appUser.getName());
            if(appUser.getUserId()!=null)criteria.andUserIdEqualTo(appUser.getUserId());
            if(appUser.getLoginname()!=null)criteria.andLoginnameLike(appUser.getLoginname());
            if(appUser.getStatus()!=null)
                criteria.andStatusEqualTo(appUser.getStatus());
             else
                criteria.andStatusEqualTo("1");
        }
        criteria.andStatusEqualTo("1");
        return this.appAdminMapper.selectUsers(appUser);
    }

    public List<AppRole> queryAllRole(Integer roleId) {
        AppRoleExample appRoleExample=new AppRoleExample();
        if (roleId!=null)
        appRoleExample.createCriteria().andRoleIdEqualTo(roleId);
        return appRoleMapper.selectByExample(appRoleExample);
    }

    /**
     * 保存用户角色关系表
     * @param userId
     * @param roles
     * @return
     */
    public List<AppUserRole> saveAppUserRole(Integer userId, String roles) {
        List<AppUserRole> appUserRoles=new ArrayList<AppUserRole>();
        AppUserRole appUserRole;
        String rolesb[]=roles.split(",");
        for (int i=0;i<rolesb.length;i++){
            appUserRole=new AppUserRole();
            appUserRole.setUserId(userId);
            appUserRole.setRoleId(Integer.valueOf(rolesb[i]));
            appUserRole.setStatus("1");
            this.appUserRoleMapper.insert(appUserRole);
            appUserRoles.add(appUserRole);
        }
        return  appUserRoles;
    }

    /**
     * 保存用户表
     * @param loginname
     * @param name
     * @param sex
     * @param roles
     */
    public void userAdd(String loginname,String name,String sex,String roles){

        AppUser appUser=new AppUser();
        appUser.setLoginname(loginname);
        appUser.setStatus("1");
        List<AppUserDTO> list=queryAllUser(appUser);
        if(list.size()>0){
            throw new BusinessException("此帐号名已经存在！");
        }
        appUser.setPassword(Md5Utils.MD5Code(loginname));
        appUser.setCtime(new Date());
        appUser.setName(name);
        appUser.setSex(sex);
        appUser.setRemoved("0");
        this.appUserMapper.insert(appUser);
        this.saveAppUserRole(appUser.getUserId(),roles);
    }

    /**
     * 修改用户
     * @param userId
     * @param loginname
     * @param name
     * @param sex
     * @param roles
     */
    public void userEdit(Integer userId,String loginname,String name,String sex,String roles){

        AppUser appUser=this.appUserMapper.selectByPrimaryKey(userId);
        appUser.setName(name);
        appUser.setSex(sex);
        this.appUserMapper.updateByPrimaryKey(appUser);

        AppUserRoleExample appUserRoleExample=new AppUserRoleExample();
        appUserRoleExample.createCriteria().andUserIdEqualTo(userId);
        this.appUserRoleMapper.deleteByExample(appUserRoleExample);

        this.saveAppUserRole(appUser.getUserId(),roles);
    }
    /**
     * 删除用户
     * @param userid
     */
    public void userDel(Integer userid){
        //删除用户
        AppUser appUser=new AppUser();
        appUser.setStatus("0");
        AppUserExample appUserExample=new AppUserExample();
        appUserExample.createCriteria().andUserIdEqualTo(userid);
        this.appUserMapper.updateByExampleSelective(appUser,appUserExample);
        //删除用户角色表
        AppUserRole appUserRole= new AppUserRole();
        appUserRole.setStatus("0");
        AppUserRoleExample appUserRoleExample=new AppUserRoleExample();
        appUserRoleExample.createCriteria().andUserIdEqualTo(userid);
        this.appUserRoleMapper.updateByExampleSelective(appUserRole,appUserRoleExample);
    }

    /**
     * 查询个人信息
     * @param userid
     * @return
     */
    public AppUserDTO queryUserInfo(int userid){
        AppUserDTO appUserDTO=new AppUserDTO();
        AppUser appUser =this.appUserMapper.selectByPrimaryKey(userid);
        if(appUser==null) return null;
        BeanUtils.copyProperties(appUser,appUserDTO);

        List<AppRole> roles=this.appAdminMapper.selectRolesByUserid(userid);
        appUserDTO.setAppRoles(roles);

        List<AppResource> appResources=this.appAdminMapper.selectResourceByUser(appUser);
        appUserDTO.setAppResources(appResources);

        return  appUserDTO;
    }
    public List<AppRoleDTO> queryAppRoleDTO(AppRole appRole){
        return this.appAdminMapper.selectRoleInfoByRoleId(appRole);
    }
    public List<AppMenu> queryAllAppMenu(AppMenu appMenu){
           AppMenuExample appMenuExample=new AppMenuExample();
           return this.appMenuMapper.selectByExample(null);
    }
    public List<AppResource> queryAllAppResource(AppResource appResource){
           AppResourceExample appResourceExample=new AppResourceExample();
           return this.appResourceMapper.selectByExample(appResourceExample);
    }
    public void updateAppRole(Integer roleId, String menus, List<AppResource> appResources){
        //删除原有
        AppRolePermissionExample appRolePermissionExample=new AppRolePermissionExample();
        appRolePermissionExample.createCriteria().andRoleIdEqualTo(roleId);
        this.appRolePermissionMapper.deleteByExample(appRolePermissionExample);
        List<AppPermission> appPermissions;
        AppRolePermission appRolePermission;
        //添加菜单
        String[] ms=menus.split(",");
        if(ms.length>0){
            for (int i=0;i<ms.length;i++){
                appPermissions=queryAppPermission(Integer.valueOf(ms[i]),"1");
                if (appPermissions.size()>0){
                    appRolePermission=new AppRolePermission();
                    appRolePermission.setRoleId(roleId);
                    appRolePermission.setPermissionId(appPermissions.get(0).getPermissionId());
                    appRolePermission.setStatus("1");
                    this.appRolePermissionMapper.insert(appRolePermission);
                }
            }
        }
        //添加资源
        if(appResources.size()>0){
            for (AppResource appResource:appResources){
                appPermissions=queryAppPermission(appResource.getResourceId(),"2");
                if (appPermissions.size()>0){
                    appRolePermission=new AppRolePermission();
                    appRolePermission.setRoleId(roleId);
                    appRolePermission.setPermissionId(appPermissions.get(0).getPermissionId());
                    appRolePermission.setStatus("1");
                    this.appRolePermissionMapper.insert(appRolePermission);
                }
            }
        }
    }
    public List<AppPermission> queryAppPermission(Integer resourceid,String type){
            AppPermissionExample appPermissionExample=new AppPermissionExample();
            appPermissionExample.createCriteria().andPermissionResourceIdEqualTo(resourceid)
                    .andPermissionTypeEqualTo(type);
            return this.appPermissionMapper.selectByExample(appPermissionExample);
    }
    public List<AppDict> queryAppDicts(AppDict appDict){
         AppDictExample appDictExample=new AppDictExample();
         AppDictExample.Criteria criteria= appDictExample.createCriteria();
         if(appDict.getDictCode()!=null)
         criteria.andDictCodeEqualTo(appDict.getDictCode());
        if(appDict.getDictId()!=null)
         criteria.andDictIdEqualTo(appDict.getDictId());
        if(StringUtility.stringHasValue(appDict.getDictName()))
         criteria.andDictNameLike("%"+appDict.getDictName()+"%");
        if(appDict.getStatus()!=null)
         criteria.andStatusEqualTo(appDict.getStatus());
         return this.appDictMapper.selectByExample(appDictExample);
    }
    public List<AppDictDetail> queryAppDictDetails(AppDictDetail appDictDetail){
        AppDictDetailExample appDictDetailExample=new AppDictDetailExample();
        AppDictDetailExample.Criteria criteria=appDictDetailExample.createCriteria();
        if(appDictDetail.getDictCode()!=null)
        criteria.andDictCodeEqualTo(appDictDetail.getDictCode());
        if(StringUtility.stringHasValue(appDictDetail.getDictName()))
            criteria.andDictNameLike("%"+appDictDetail.getDictName()+"%");
        if(appDictDetail.getStatus()!=null)
            criteria.andStatusEqualTo(appDictDetail.getStatus());
        appDictDetailExample.setOrderByClause("priority");
        return this.appDictDetailMapper.selectByExample(appDictDetailExample);
    }
    public void addAppDict(AppDict appDict,List<AppDictDetail> appDictDetails){
        if(appDict.getDictCode()==null||appDict.getDictName()==null) return;
        appDict.setDictCode(appDict.getDictCode().toUpperCase());
        if(queryAppDicts(appDict).size()>0)
            throw new BusinessException("此字典已经存在");
        this.appDictMapper.insert(appDict);
        if(appDictDetails!=null){
            for (AppDictDetail appDictDetail:appDictDetails) {
                addAppDictDetail(appDict.getDictCode(), appDictDetail);
            }
        }
    }
    public void addAppDictDetail(String dictCode,AppDictDetail appDictDetail){
        if(appDictDetail.getDictName()==null||appDictDetail.getDictCode()==null) return;
        int maxval=this.appAdminMapper.selectMaxDictValByCode(dictCode);
        appDictDetail.setDictCode(dictCode);
        appDictDetail.setDictVal(String.valueOf(maxval+1));
        this.appDictDetailMapper.insert(appDictDetail);
    }
    public void refreashContext(ServletContext context, String dictCode ){
        AppDict appDict=new AppDict();
        appDict.setDictCode(dictCode);
        appDict.setStatus("1");
        List<AppDict> appDicts = queryAppDicts(appDict);
        if(appDicts!=null){
            for(int i=0;i<appDicts.size();i++){
                AppDictDetail appDictDetail=new AppDictDetail();
                appDictDetail.setDictCode(appDicts.get(i).getDictCode());
                appDictDetail.setStatus("1");
                List<AppDictDetail> appDictDetails = queryAppDictDetails(appDictDetail);
                if(appDictDetails!=null&&appDictDetails.size()>0){
                    if(appDicts.get(i).getDictCode()!=null)
                        context.setAttribute(appDicts.get(i).getDictCode().toUpperCase(), appDictDetails);
                }
            }
        }
    }
    public void updateAppDict(AppDict appDict){
        this.appDictMapper.updateByPrimaryKeySelective(appDict);
    }
    public void updateAppDictDetail(AppDictDetail appDictDetail){
        this.appDictDetailMapper.updateByPrimaryKeySelective(appDictDetail);
    }


    /**
     * 保存通知，站内信,文章    1 通知，2站内信息,3文章
     */
    public AppNotice saveAppNotice(AppNotice appNotice,String users){
        AppUserDTO appUserDTO= (AppUserDTO) SecurityUtils.getSubject().getSession().getAttribute("user");
        appNotice.setUserId(appUserDTO.getUserId());
        appNotice.setCtime(new Date());
        if(appNotice.getNoticeId()!=null)
            this.appNoticeMapper.updateByPrimaryKeySelective(appNotice);
            else
        this.appNoticeMapper.insert(appNotice);
        //如果是站内信息
        if(appNotice.getNoticeType().equals("2")){
           String userArray[]= users.split(",");
           AppNoticeUser appNoticeUser;
           for(int i=0;i<userArray.length&&users.length()>0;i++){
               saveAppNoticeUser(appNotice.getNoticeId(),Integer.valueOf(userArray[i]));
           }
           //如果是文章通知
        }else{
            if("all".equals(users)) {
                List<AppUserDTO> appUsers = queryAllUser(null);
                for (AppUser appUser : appUsers) {
                    saveAppNoticeUser(appNotice.getNoticeId(), appUser.getUserId());
                }
            }
        }
        return appNotice;
    }
    public void saveAppNoticeUser(Integer noticeId,Integer userId){
        AppNoticeUser appNoticeUser=new AppNoticeUser();
        appNoticeUser.setNoticeId(noticeId);
        appNoticeUser.setUserId(Integer.valueOf(userId));
        appNoticeUser.setNoticeIsread("0");
        this.appNoticeUserMapper.insert(appNoticeUser);
    }

    /**
     * 更新为已经读取
     * @param appNoticeUser
     */
    public void updateAppNoticeUser(AppNoticeUser appNoticeUser){
      AppNoticeUserExample appNoticeUserExample=new AppNoticeUserExample();
      AppNoticeUserExample.Criteria criteria=appNoticeUserExample.createCriteria();
     if(appNoticeUser.getNoticeId()!=null) criteria.andNoticeIdEqualTo(appNoticeUser.getNoticeId());
      if(appNoticeUser.getUserId()!=null)criteria.andUserIdEqualTo(appNoticeUser.getUserId());
      if(appNoticeUser.getNoticeUserId()!=null) criteria.andNoticeUserIdEqualTo(appNoticeUser.getNoticeUserId());
       this.appNoticeUserMapper.updateByExampleSelective(appNoticeUser,appNoticeUserExample);
    }


    /**
     * 删除通知
     * @param noticeId
     * @param removed
     */
    public void updateAppNotice(Integer noticeId,String removed){
        AppNotice appNotice=new AppNotice();
        appNotice.setNoticeId(noticeId);
        appNotice.setRemoved(removed);
        this.appNoticeMapper.updateByPrimaryKeySelective(appNotice);
    }

    /**
     * 查询通知公告文章
     * @param appNoticeDTO
     * @return
     */
    public List<AppNoticeDTO> queryPreNotice(AppNoticeDTO appNoticeDTO){
        List<AppNoticeDTO> appNoticeDTOS= this.appAdminMapper.selectAppNotice(appNoticeDTO);
        for(AppNoticeDTO appNoticeDTO1:appNoticeDTOS){
            appNoticeDTO1.setAppNoticeAttachmentList(queryAppNoticeAttachment(appNoticeDTO1.getNoticeId()));
        }
        return  appNoticeDTOS;
    }

    /**
     * 自定义查询能和方法
     * @param appNoticeDTO
     * @return
     */
    public List<AppNoticeDTO> selectAppNoticeResult(AppNoticeDTO appNoticeDTO){
        return  this.appAdminMapper.selectAppNoticeResult(appNoticeDTO);
    }
    public List<AppNoticeDTO> queryNotices(AppNotice appNotice){
        AppNoticeExample appNoticeExample=new AppNoticeExample();
        AppNoticeExample.Criteria criteria=appNoticeExample.createCriteria();
        if (StringUtils.hasText(appNotice.getNoticeTitle()))
        criteria.andNoticeTitleLike("%"+appNotice.getNoticeTitle()+"%");
        if (StringUtils.hasText(appNotice.getNoticeType()))
            criteria.andNoticeTypeEqualTo(appNotice.getNoticeType());
        if (appNotice.getUserId()!=null)
            criteria.andUserIdEqualTo(appNotice.getUserId());
        if (appNotice.getNoticeId()!=null)
            criteria.andNoticeIdEqualTo(appNotice.getNoticeId());
        appNoticeExample.setOrderByClause(" ctime desc ");
        List<AppNotice> appNoticeList=  this.appNoticeMapper.selectByExample(appNoticeExample);
        List<AppNoticeDTO> appNoticeDTOS=new ArrayList<AppNoticeDTO>();
        AppNoticeDTO appNoticeDTO;
        for(AppNotice appNotice1:appNoticeList){
            appNoticeDTO=new AppNoticeDTO();
            BeanUtils.copyProperties(appNotice1,appNoticeDTO);
            appNoticeDTO.setAppNoticeAttachmentList(queryAppNoticeAttachment(appNotice1.getNoticeId()));
            appNoticeDTOS.add(appNoticeDTO);
        }
        return  appNoticeDTOS;
    }
    public List<AppNoticeAttachment> queryAppNoticeAttachment(Integer noticeid){
        AppNoticeAttachmentExample appNoticeAttachmentExample=new AppNoticeAttachmentExample();
        AppNoticeAttachmentExample.Criteria criteria=appNoticeAttachmentExample.createCriteria();
        criteria.andNoticeIdEqualTo(noticeid);
        return  this.appNoticeAttachmentMapper.selectByExample(appNoticeAttachmentExample);
    }
    public AppNoticeAttachment saveAppNoticeAttachment(AppNoticeAttachment appNoticeAttachment){
        this.appNoticeAttachmentMapper.insert(appNoticeAttachment);
        return appNoticeAttachment;
    }
    public AppNoticeAttachment queryAppNoticeAttachentByid(Integer attid){
        return this.appNoticeAttachmentMapper.selectByPrimaryKey(attid);
    }
}
