package com.xuechen.web.dto;

import com.xuechen.web.bo.AppMenu;

import java.util.List;

public class AppMenuDTO extends AppMenu {

    private List<AppMenu> subMenus;

    public List<AppMenu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<AppMenu> subMenus) {
        this.subMenus = subMenus;
    }
}
