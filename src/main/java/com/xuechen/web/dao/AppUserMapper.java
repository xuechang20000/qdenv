package com.xuechen.web.dao;

import com.xuechen.web.bo.AppUser;
import com.xuechen.web.bo.AppUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppUserMapper {
    int countByExample(AppUserExample example);

    int deleteByExample(AppUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(AppUser record);

    int insertSelective(AppUser record);

    List<AppUser> selectByExampleWithBLOBs(AppUserExample example);

    List<AppUser> selectByExample(AppUserExample example);

    AppUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") AppUser record, @Param("example") AppUserExample example);

    int updateByExampleWithBLOBs(@Param("record") AppUser record, @Param("example") AppUserExample example);

    int updateByExample(@Param("record") AppUser record, @Param("example") AppUserExample example);

    int updateByPrimaryKeySelective(AppUser record);

    int updateByPrimaryKeyWithBLOBs(AppUser record);

    int updateByPrimaryKey(AppUser record);
}