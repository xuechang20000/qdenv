package com.xuechen.web.dao;

import com.xuechen.web.bo.AppUserOrgan;
import com.xuechen.web.bo.AppUserOrganExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppUserOrganMapper {
    int countByExample(AppUserOrganExample example);

    int deleteByExample(AppUserOrganExample example);

    int deleteByPrimaryKey(Integer organId);

    int insert(AppUserOrgan record);

    int insertSelective(AppUserOrgan record);

    List<AppUserOrgan> selectByExample(AppUserOrganExample example);

    AppUserOrgan selectByPrimaryKey(Integer organId);

    int updateByExampleSelective(@Param("record") AppUserOrgan record, @Param("example") AppUserOrganExample example);

    int updateByExample(@Param("record") AppUserOrgan record, @Param("example") AppUserOrganExample example);

    int updateByPrimaryKeySelective(AppUserOrgan record);

    int updateByPrimaryKey(AppUserOrgan record);
}