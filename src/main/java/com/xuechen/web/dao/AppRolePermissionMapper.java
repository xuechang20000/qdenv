package com.xuechen.web.dao;

import com.xuechen.web.bo.AppRolePermission;
import com.xuechen.web.bo.AppRolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppRolePermissionMapper {
    int countByExample(AppRolePermissionExample example);

    int deleteByExample(AppRolePermissionExample example);

    int deleteByPrimaryKey(Integer rolePermissionId);

    int insert(AppRolePermission record);

    int insertSelective(AppRolePermission record);

    List<AppRolePermission> selectByExample(AppRolePermissionExample example);

    AppRolePermission selectByPrimaryKey(Integer rolePermissionId);

    int updateByExampleSelective(@Param("record") AppRolePermission record, @Param("example") AppRolePermissionExample example);

    int updateByExample(@Param("record") AppRolePermission record, @Param("example") AppRolePermissionExample example);

    int updateByPrimaryKeySelective(AppRolePermission record);

    int updateByPrimaryKey(AppRolePermission record);
}