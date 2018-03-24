package com.xuechen.web.service.impl;

import com.xuechen.web.bo.AppUserExample;
import com.xuechen.web.dao.AppAdminMapper;
import com.xuechen.web.dao.AppLogLoginMapper;
import com.xuechen.web.dao.AppUserMapper;
import com.xuechen.web.dto.AppUserDTO;
import com.xuechen.web.bo.AppLogLogin;
import com.xuechen.web.bo.AppResource;
import com.xuechen.web.bo.AppUser;
import com.xuechen.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AppUserMapper appUserMapper;
    @Autowired
    private AppAdminMapper appAdminMapper;
    @Autowired
    private AppLogLoginMapper appLogLoginMapper;

    public AppAdminMapper getAppAdminMapper() {
        return appAdminMapper;
    }

    public void setAppAdminMapper(AppAdminMapper appAdminMapper) {
        this.appAdminMapper = appAdminMapper;
    }

    public AppLogLoginMapper getAppLogLoginMapper() {
        return appLogLoginMapper;
    }

    public void setAppLogLoginMapper(AppLogLoginMapper appLogLoginMapper) {
        this.appLogLoginMapper = appLogLoginMapper;
    }

    public AppUserMapper getAppUserMapper() {
        return appUserMapper;
    }

    public void setAppUserMapper(AppUserMapper appUserMapper) {
        this.appUserMapper = appUserMapper;
    }

    public List<AppUserDTO> queryUserByUser(AppUser appUser) {
       return appAdminMapper.selectUserByUser(appUser);
    }
    public List<AppUserDTO> queryPassworkByUser(AppUser appUser) {
        return appAdminMapper.queryPassworkByUser(appUser);
    }
    public List<AppResource> selectResourceByUser(AppUser appUser){
        return  appAdminMapper.selectResourceByUser(appUser);
    }
    public void saveAppLogLogin(AppLogLogin appLogLogin){
        this.appLogLoginMapper.insert(appLogLogin);
    }
    public void updatePassword(AppUser appUser){

        this.appUserMapper.updateByPrimaryKeySelective(appUser);
    }
    public void updateSignature(AppUser appUser){
        AppUser appUser1=this.appUserMapper.selectByPrimaryKey(appUser.getUserId());
        appUser1.setSignature(appUser.getSignature());
        this.appUserMapper.updateByPrimaryKeyWithBLOBs(appUser1);
    }
    public AppUser querySignature(AppUser appUser){
        AppUserExample appUserExample=new AppUserExample();
        AppUserExample.Criteria criteria= appUserExample.createCriteria();
        criteria.andUserIdEqualTo(appUser.getUserId());
        List<AppUser> appUser1=this.appUserMapper.selectByExampleWithBLOBs(appUserExample);
        return appUser1.get(0);
    }
}
