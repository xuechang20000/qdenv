package com.xuechen.web.dao;

import com.xuechen.web.bo.AppNotice;
import com.xuechen.web.bo.AppNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppNoticeMapper {
    int countByExample(AppNoticeExample example);

    int deleteByExample(AppNoticeExample example);

    int deleteByPrimaryKey(Integer noticeId);

    int insert(AppNotice record);

    int insertSelective(AppNotice record);

    List<AppNotice> selectByExampleWithBLOBs(AppNoticeExample example);

    List<AppNotice> selectByExample(AppNoticeExample example);

    AppNotice selectByPrimaryKey(Integer noticeId);

    int updateByExampleSelective(@Param("record") AppNotice record, @Param("example") AppNoticeExample example);

    int updateByExampleWithBLOBs(@Param("record") AppNotice record, @Param("example") AppNoticeExample example);

    int updateByExample(@Param("record") AppNotice record, @Param("example") AppNoticeExample example);

    int updateByPrimaryKeySelective(AppNotice record);

    int updateByPrimaryKeyWithBLOBs(AppNotice record);

    int updateByPrimaryKey(AppNotice record);
}