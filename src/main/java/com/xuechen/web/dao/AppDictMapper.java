package com.xuechen.web.dao;

import com.xuechen.web.bo.AppDict;
import com.xuechen.web.bo.AppDictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppDictMapper {
    int countByExample(AppDictExample example);

    int deleteByExample(AppDictExample example);

    int deleteByPrimaryKey(Integer dictId);

    int insert(AppDict record);

    int insertSelective(AppDict record);

    List<AppDict> selectByExample(AppDictExample example);

    AppDict selectByPrimaryKey(Integer dictId);

    int updateByExampleSelective(@Param("record") AppDict record, @Param("example") AppDictExample example);

    int updateByExample(@Param("record") AppDict record, @Param("example") AppDictExample example);

    int updateByPrimaryKeySelective(AppDict record);

    int updateByPrimaryKey(AppDict record);
}