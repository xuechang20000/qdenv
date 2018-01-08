package com.xuechen.web.dao;

import com.xuechen.web.bo.AppLogUrl;
import com.xuechen.web.bo.AppLogUrlExample;
import com.xuechen.web.bo.AppLogUrlWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppLogUrlMapper {
    int countByExample(AppLogUrlExample example);

    int deleteByExample(AppLogUrlExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppLogUrlWithBLOBs record);

    int insertSelective(AppLogUrlWithBLOBs record);

    List<AppLogUrlWithBLOBs> selectByExampleWithBLOBs(AppLogUrlExample example);

    List<AppLogUrl> selectByExample(AppLogUrlExample example);

    AppLogUrlWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppLogUrlWithBLOBs record, @Param("example") AppLogUrlExample example);

    int updateByExampleWithBLOBs(@Param("record") AppLogUrlWithBLOBs record, @Param("example") AppLogUrlExample example);

    int updateByExample(@Param("record") AppLogUrl record, @Param("example") AppLogUrlExample example);

    int updateByPrimaryKeySelective(AppLogUrlWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AppLogUrlWithBLOBs record);

    int updateByPrimaryKey(AppLogUrl record);
}