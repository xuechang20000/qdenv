package com.xuechen.web.dao;

import com.xuechen.web.bo.AppLogLogin;
import com.xuechen.web.bo.AppLogLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppLogLoginMapper {
    int countByExample(AppLogLoginExample example);

    int deleteByExample(AppLogLoginExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppLogLogin record);

    int insertSelective(AppLogLogin record);

    List<AppLogLogin> selectByExample(AppLogLoginExample example);

    AppLogLogin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppLogLogin record, @Param("example") AppLogLoginExample example);

    int updateByExample(@Param("record") AppLogLogin record, @Param("example") AppLogLoginExample example);

    int updateByPrimaryKeySelective(AppLogLogin record);

    int updateByPrimaryKey(AppLogLogin record);
}