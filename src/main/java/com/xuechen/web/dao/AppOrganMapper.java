package com.xuechen.web.dao;

import com.xuechen.web.bo.AppOrgan;
import com.xuechen.web.bo.AppOrganExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppOrganMapper {
    int countByExample(AppOrganExample example);

    int deleteByExample(AppOrganExample example);

    int deleteByPrimaryKey(Integer organId);

    int insert(AppOrgan record);

    int insertSelective(AppOrgan record);

    List<AppOrgan> selectByExample(AppOrganExample example);

    AppOrgan selectByPrimaryKey(Integer organId);

    int updateByExampleSelective(@Param("record") AppOrgan record, @Param("example") AppOrganExample example);

    int updateByExample(@Param("record") AppOrgan record, @Param("example") AppOrganExample example);

    int updateByPrimaryKeySelective(AppOrgan record);

    int updateByPrimaryKey(AppOrgan record);
}