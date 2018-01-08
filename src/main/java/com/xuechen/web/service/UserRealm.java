package com.xuechen.web.service;

import com.xuechen.web.bo.AppResource;
import com.xuechen.web.bo.AppRole;
import com.xuechen.web.bo.AppUser;
import com.xuechen.web.dto.AppUserDTO;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserRealm extends AuthorizingRealm {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private UserService userService;


    /**
     * 提供用户信息返回权限信息
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String loginname=(String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        AppUser appUser=new AppUser();
        appUser.setLoginname(loginname);
        List<AppUserDTO> appUserDTOList=userService.queryUserByUser(appUser);
        /**
         * 获取角色列表
         */
        if (appUserDTOList!=null&&appUserDTOList.size()>0){
            List<AppRole> appRoles= appUserDTOList.get(0).getAppRoles();
            if(appRoles!=null){
                Set<String> roles= new HashSet<String>();
                for(AppRole appRole:appRoles){
                    roles.add(appRole.getRoleCode());
                }
                authorizationInfo.setRoles(roles);
            }
            /**
             * 获取权限列表
             */
            List<AppResource> appResources=userService.selectResourceByUser(appUser);
            if(appResources!=null){
                Set<String> permissions= new HashSet<String>();
                for(AppResource appResource:appResources){
                    permissions.add(appResource.getResourceCode());
                }
                authorizationInfo.setStringPermissions(permissions);
            }
        }
        return authorizationInfo;
    }
    /**
     * 提供账户信息返回认证信息
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String loginname=(String) authenticationToken.getPrincipal();

        AppUser appUser=new AppUser();
        appUser.setLoginname(loginname);

        List<AppUserDTO> appUserDTOList=userService.queryPassworkByUser(appUser);

        if (appUserDTOList==null||appUserDTOList.size()==0){
            throw new UnknownAccountException();
        }
        AppUserDTO appUserDTO=appUserDTOList.get(0);
;
        SimpleAuthenticationInfo  authenticationInfo = new SimpleAuthenticationInfo(loginname,
                appUserDTO.getPassword(), getName());
        return  authenticationInfo;
    }

}
