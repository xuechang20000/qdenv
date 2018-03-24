package com.xuechen.web.service;



import com.xuechen.web.bo.AppLogLogin;
import com.xuechen.web.bo.AppResource;
import com.xuechen.web.bo.AppUser;
import com.xuechen.web.dto.AppUserDTO;

import java.util.List;


public interface UserService {

     public List<AppUserDTO> queryUserByUser(AppUser appUser);
     public List<AppUserDTO> queryPassworkByUser(AppUser appUser);
     public List<AppResource> selectResourceByUser(AppUser appUser);
     public void saveAppLogLogin(AppLogLogin appLogLogin);
     public void updatePassword(AppUser appUser);
     public void updateSignature(AppUser appUser);
     public AppUser querySignature(AppUser appUser);
}
