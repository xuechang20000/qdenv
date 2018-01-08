package com.xuechen.web.dao;

import com.xuechen.web.bo.AppMenu;
import com.xuechen.web.bo.AppMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppMenuMapper {
    int countByExample(AppMenuExample example);

    int deleteByExample(AppMenuExample example);

    int deleteByPrimaryKey(Integer menuId);

    int insert(AppMenu record);

    int insertSelective(AppMenu record);

    List<AppMenu> selectByExample(AppMenuExample example);

    AppMenu selectByPrimaryKey(Integer menuId);

    int updateByExampleSelective(@Param("record") AppMenu record, @Param("example") AppMenuExample example);

    int updateByExample(@Param("record") AppMenu record, @Param("example") AppMenuExample example);

    int updateByPrimaryKeySelective(AppMenu record);

    int updateByPrimaryKey(AppMenu record);
}