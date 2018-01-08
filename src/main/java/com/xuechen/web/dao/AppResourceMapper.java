package com.xuechen.web.dao;

import com.xuechen.web.bo.AppResource;
import com.xuechen.web.bo.AppResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppResourceMapper {
    int countByExample(AppResourceExample example);

    int deleteByExample(AppResourceExample example);

    int deleteByPrimaryKey(Integer resourceId);

    int insert(AppResource record);

    int insertSelective(AppResource record);

    List<AppResource> selectByExample(AppResourceExample example);

    AppResource selectByPrimaryKey(Integer resourceId);

    int updateByExampleSelective(@Param("record") AppResource record, @Param("example") AppResourceExample example);

    int updateByExample(@Param("record") AppResource record, @Param("example") AppResourceExample example);

    int updateByPrimaryKeySelective(AppResource record);

    int updateByPrimaryKey(AppResource record);
}