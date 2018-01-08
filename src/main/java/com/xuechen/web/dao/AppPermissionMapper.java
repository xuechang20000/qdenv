package com.xuechen.web.dao;

import com.xuechen.web.bo.AppPermission;
import com.xuechen.web.bo.AppPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppPermissionMapper {
    int countByExample(AppPermissionExample example);

    int deleteByExample(AppPermissionExample example);

    int deleteByPrimaryKey(Integer permissionId);

    int insert(AppPermission record);

    int insertSelective(AppPermission record);

    List<AppPermission> selectByExample(AppPermissionExample example);

    AppPermission selectByPrimaryKey(Integer permissionId);

    int updateByExampleSelective(@Param("record") AppPermission record, @Param("example") AppPermissionExample example);

    int updateByExample(@Param("record") AppPermission record, @Param("example") AppPermissionExample example);

    int updateByPrimaryKeySelective(AppPermission record);

    int updateByPrimaryKey(AppPermission record);
}