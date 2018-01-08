package com.xuechen.web.dao;

import com.xuechen.web.bo.AppDictDetail;
import com.xuechen.web.bo.AppDictDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppDictDetailMapper {
    int countByExample(AppDictDetailExample example);

    int deleteByExample(AppDictDetailExample example);

    int deleteByPrimaryKey(Integer dictId);

    int insert(AppDictDetail record);

    int insertSelective(AppDictDetail record);

    List<AppDictDetail> selectByExample(AppDictDetailExample example);

    AppDictDetail selectByPrimaryKey(Integer dictId);

    int updateByExampleSelective(@Param("record") AppDictDetail record, @Param("example") AppDictDetailExample example);

    int updateByExample(@Param("record") AppDictDetail record, @Param("example") AppDictDetailExample example);

    int updateByPrimaryKeySelective(AppDictDetail record);

    int updateByPrimaryKey(AppDictDetail record);
}