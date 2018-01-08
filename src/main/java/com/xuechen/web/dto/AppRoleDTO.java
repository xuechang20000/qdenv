package com.xuechen.web.dto;



import com.xuechen.web.bo.AppMenu;
import com.xuechen.web.bo.AppResource;
import com.xuechen.web.bo.AppRole;

import java.util.List;

public class AppRoleDTO extends AppRole {
    private List<AppMenu> appMenuList;

    public List<AppResource> getAppResourceList() {
        return appResourceList;
    }

    public void setAppResourceList(List<AppResource> appResourceList) {
        this.appResourceList = appResourceList;
    }

    private List<AppResource> appResourceList;

    public List<AppMenu> getAppMenuList() {
        return appMenuList;
    }

    public void setAppMenuList(List<AppMenu> appMenuList) {
        this.appMenuList = appMenuList;
    }
}
