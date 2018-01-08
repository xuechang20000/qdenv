package com.xuechen.web.service;


import com.xuechen.web.bo.*;
import com.xuechen.web.dto.AppNoticeDTO;
import com.xuechen.web.dto.AppRoleDTO;
import com.xuechen.web.dto.AppUserDTO;

import javax.servlet.ServletContext;
import java.util.List;

public interface AdminService {
    public List<AppUser> queryAllUser(AppUser appUser);
    public List<AppRole> queryAllRole(Integer roleId);
    public List<AppUserRole> saveAppUserRole(Integer userId, String roles);
    public void userAdd(String loginname, String name, String sex, String roles);
    public void userDel(Integer userid);
    public AppUserDTO queryUserInfo(int userid);
    public void userEdit(Integer userId, String loginname, String name, String sex, String roles);
    public List<AppRoleDTO> queryAppRoleDTO(AppRole appRole);
    public List<AppMenu> queryAllAppMenu(AppMenu appMenu);
    public List<AppResource> queryAllAppResource(AppResource appResource);
    public void updateAppRole(Integer roleId, String menus, List<AppResource> appResources);
    public List<AppPermission> queryAppPermission(Integer resourceid, String type);
    public List<AppDict> queryAppDicts(AppDict appDict);
    public List<AppDictDetail> queryAppDictDetails(AppDictDetail appDictDetail);
    public void addAppDict(AppDict appDict, List<AppDictDetail> appDictDetails);
    public void addAppDictDetail(String dictCode, AppDictDetail appDictDetail);
    public void updateAppDict(AppDict appDict);
    public void updateAppDictDetail(AppDictDetail appDictDetail);
    public void refreashContext(ServletContext context, String dictCode);
    public AppNotice saveAppNotice(AppNotice appNotice,String users);
    public void saveAppNoticeUser(Integer noticeId,Integer userId);
    public void updateAppNoticeUser(AppNoticeUser appNoticeUser);
    public void updateAppNotice(Integer noticeId,String removed);
    public List<AppNoticeDTO> queryPreNotice(AppNoticeDTO appNoticeDTO);
    public List<AppNoticeDTO> queryNotices(AppNotice appNotice);
    public List<AppNoticeDTO> selectAppNoticeResult(AppNoticeDTO appNoticeDTO);
    public List<AppNoticeAttachment> queryAppNoticeAttachment(Integer noticeid);
    public AppNoticeAttachment saveAppNoticeAttachment(AppNoticeAttachment appNoticeAttachment);
    public AppNoticeAttachment queryAppNoticeAttachentByid(Integer attid);
}
