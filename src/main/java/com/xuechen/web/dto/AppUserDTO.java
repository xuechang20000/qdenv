package com.xuechen.web.dto;



import com.xuechen.web.bo.AppMenu;
import com.xuechen.web.bo.AppResource;
import com.xuechen.web.bo.AppRole;
import com.xuechen.web.bo.AppUser;

import java.util.List;

public class AppUserDTO extends AppUser {
    private List<AppRole> appRoles;
    private List<AppMenu> appMenus;

    public List<AppResource> getAppResources() {
        return appResources;
    }

    public void setAppResources(List<AppResource> appResources) {
        this.appResources = appResources;
    }

    private List<AppResource> appResources;
    public List<AppRole> getAppRoles() {
        return appRoles;
    }

    public void setAppRoles(List<AppRole> appRoles) {
        this.appRoles = appRoles;
    }

    public List<AppMenu> getAppMenus() {
        return appMenus;
    }

    public void setAppMenus(List<AppMenu> appMenus) {
        this.appMenus = appMenus;
    }
}
