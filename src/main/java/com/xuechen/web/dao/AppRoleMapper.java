package com.xuechen.web.dao;

import com.xuechen.web.bo.AppRole;
import com.xuechen.web.bo.AppRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppRoleMapper {
    int countByExample(AppRoleExample example);

    int deleteByExample(AppRoleExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(AppRole record);

    int insertSelective(AppRole record);

    List<AppRole> selectByExample(AppRoleExample example);

    AppRole selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") AppRole record, @Param("example") AppRoleExample example);

    int updateByExample(@Param("record") AppRole record, @Param("example") AppRoleExample example);

    int updateByPrimaryKeySelective(AppRole record);

    int updateByPrimaryKey(AppRole record);
}