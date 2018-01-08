package com.xuechen.web.dao;

import com.xuechen.web.bo.AppUserRole;
import com.xuechen.web.bo.AppUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppUserRoleMapper {
    int countByExample(AppUserRoleExample example);

    int deleteByExample(AppUserRoleExample example);

    int deleteByPrimaryKey(Integer userRoleId);

    int insert(AppUserRole record);

    int insertSelective(AppUserRole record);

    List<AppUserRole> selectByExample(AppUserRoleExample example);

    AppUserRole selectByPrimaryKey(Integer userRoleId);

    int updateByExampleSelective(@Param("record") AppUserRole record, @Param("example") AppUserRoleExample example);

    int updateByExample(@Param("record") AppUserRole record, @Param("example") AppUserRoleExample example);

    int updateByPrimaryKeySelective(AppUserRole record);

    int updateByPrimaryKey(AppUserRole record);
}