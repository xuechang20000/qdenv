package com.xuechen.web.dao;

import com.xuechen.web.bo.AppPermissionType;
import com.xuechen.web.bo.AppPermissionTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppPermissionTypeMapper {
    int countByExample(AppPermissionTypeExample example);

    int deleteByExample(AppPermissionTypeExample example);

    int deleteByPrimaryKey(Integer permissionTypeId);

    int insert(AppPermissionType record);

    int insertSelective(AppPermissionType record);

    List<AppPermissionType> selectByExample(AppPermissionTypeExample example);

    AppPermissionType selectByPrimaryKey(Integer permissionTypeId);

    int updateByExampleSelective(@Param("record") AppPermissionType record, @Param("example") AppPermissionTypeExample example);

    int updateByExample(@Param("record") AppPermissionType record, @Param("example") AppPermissionTypeExample example);

    int updateByPrimaryKeySelective(AppPermissionType record);

    int updateByPrimaryKey(AppPermissionType record);
}