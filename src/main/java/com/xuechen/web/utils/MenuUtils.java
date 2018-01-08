package com.xuechen.web.utils;



import com.xuechen.core.utils.dto.MenuDTO;
import com.xuechen.core.utils.dto.MiniMenuDTO;
import com.xuechen.web.bo.AppMenu;
import com.xuechen.web.dto.AppMenuDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MenuUtils {

    public static List<MiniMenuDTO> transMensToMiniDtos(List<AppMenu> menus){
        List<MiniMenuDTO> miniMenuDTOS=new ArrayList<MiniMenuDTO>();
        MiniMenuDTO miniMenuDTO;
        for(AppMenu appMenu:menus){
            /**
             * 最顶级菜单暂时跳过
             */
            if(appMenu.getParentMenuId()==null) continue;
            miniMenuDTO=new MiniMenuDTO();
            miniMenuDTO.setId(appMenu.getMenuId());
            if(appMenu.getParentMenuId()!=null)
            miniMenuDTO.setPid(appMenu.getParentMenuId());
            miniMenuDTO.setIconCls(appMenu.getIcon1());
            miniMenuDTO.setIconPosition(appMenu.getIcon2());
            miniMenuDTO.setUrl(appMenu.getUrl());
            miniMenuDTO.setText(appMenu.getName());
            miniMenuDTOS.add(miniMenuDTO);
        }
        return  miniMenuDTOS;
    }
    public static List<MiniMenuDTO> getTopMiniMenus(List<AppMenu> menus){
        List<MiniMenuDTO> miniMenuDTOS=new ArrayList<MiniMenuDTO>();
        MiniMenuDTO miniMenuDTO;
        for(AppMenu appMenu:menus){
            if(appMenu.getParentMenuId()!=null) continue;;
            miniMenuDTO=new MiniMenuDTO();
            miniMenuDTO.setId(appMenu.getMenuId());
            miniMenuDTO.setIconCls(appMenu.getIcon1());
            miniMenuDTO.setUrl(appMenu.getUrl());
            miniMenuDTO.setText(appMenu.getName());
            miniMenuDTOS.add(miniMenuDTO);
        }
        return  miniMenuDTOS;
    }
    public static List<MiniMenuDTO> getSubMiniMenus(Integer topMiniId,List<AppMenu> menus){

        return  getMiniChilden(topMiniId,menus);
    }
    @Deprecated
    public static List<MenuDTO> getMenus(List<AppMenu> menus){
        List<MenuDTO> menuDTOS=new ArrayList<MenuDTO>();

        List<AppMenu> topAppMenus=getTopMenus(menus);
        MenuDTO menuDTO=null;
        for (AppMenu appMenu:topAppMenus){
            menuDTO=new MenuDTO();
            menuDTO.setId(appMenu.getMenuId().toString());
            menuDTO.setTitle(appMenu.getName());
            menuDTO.setHref(appMenu.getUrl());
            menuDTO.setIcon(appMenu.getIcon1());
            menuDTO.setSpread(false);
            menuDTO.setChildren(getChilden(appMenu,menus));
            menuDTOS.add(menuDTO);
        }
        return  menuDTOS;
    }
    @Deprecated
    public  static List<AppMenu> getTopMenus(List<AppMenu> menus){
        List<AppMenu> appMenuList=new ArrayList<AppMenu>();
        for (AppMenu appMenu:menus){
            if(appMenu.getParentMenuId()==null){
                appMenuList.add(appMenu);
            }
        }
        return  appMenuList;
    }
    @Deprecated
    public  static List<MenuDTO> getChilden(AppMenu menu,List<AppMenu> appMenus){
        List<MenuDTO> menuDTOS=new ArrayList<MenuDTO>();
        MenuDTO menuDTO=null;
        for (AppMenu appMenu:appMenus){
            if(appMenu.getParentMenuId()!=null&&appMenu.getParentMenuId().equals(menu.getMenuId())){
                menuDTO=new MenuDTO();
                menuDTO.setId(appMenu.getMenuId().toString());
                menuDTO.setTitle(appMenu.getName());
                menuDTO.setHref(appMenu.getUrl());
                menuDTO.setIcon(appMenu.getIcon1());
                menuDTO.setSpread(false);
                menuDTO.setChildren(getChilden(appMenu,appMenus));
                menuDTOS.add(menuDTO);
            }
        }
        return menuDTOS;

    }
    public  static List<MiniMenuDTO> getMiniChilden(Integer miniid,List<AppMenu> appMenus){
        List<MiniMenuDTO> miniMenuDTOS=new ArrayList<MiniMenuDTO>();
        MiniMenuDTO miniMenuDTO=null;
        for (AppMenu appMenu:appMenus){
            if(appMenu.getParentMenuId()!=null&&appMenu.getParentMenuId().equals(miniid)){
                miniMenuDTO=new MiniMenuDTO();
                miniMenuDTO.setId(appMenu.getMenuId());
                miniMenuDTO.setText(appMenu.getName());
                miniMenuDTO.setUrl(appMenu.getUrl());
                miniMenuDTO.setIconCls(appMenu.getIcon1());
                miniMenuDTOS.add(miniMenuDTO);
                miniMenuDTOS.addAll(getMiniChilden(appMenu.getMenuId(),appMenus));
            }
        }
        return miniMenuDTOS;

    }
    public  static List<AppMenu> getAppMenuChilden(AppMenu menu,List<AppMenu> appMenus){
        List<AppMenu> appMenuList=new ArrayList<AppMenu>();
        for (AppMenu am:appMenus){
            if(am.getParentMenuId()!=null&&am.getParentMenuId().equals(menu.getMenuId())){
                appMenuList.add(am);
            }
        }
        return appMenuList;
    }
    public static List<AppMenuDTO> menuToLevel(List<AppMenu> appMenus){

        List<AppMenuDTO> returnList=new ArrayList<AppMenuDTO>();
        AppMenuDTO appMenuDTO=null;
        for (AppMenu appMenu:appMenus){
            if (appMenu.getParentMenuId()==null) continue;
            if (appMenu.getMenuId()>=1000&&appMenu.getMenuId()<10000){
                appMenuDTO=new AppMenuDTO();
                appMenuDTO.setMenuId(appMenu.getMenuId());
                appMenuDTO.setName(appMenu.getName());
                appMenuDTO.setUrl(appMenu.getUrl());
                appMenuDTO.setIcon1(appMenu.getIcon1());
                appMenuDTO.setIcon2(appMenu.getIcon2());
                appMenuDTO.setSubMenus(getAppMenuChilden(appMenu,appMenus));
                returnList.add(appMenuDTO);
            }

        }
        return  returnList;
    }
}
