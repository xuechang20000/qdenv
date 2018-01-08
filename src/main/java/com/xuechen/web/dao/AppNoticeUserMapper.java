package com.xuechen.web.dao;

import com.xuechen.web.bo.AppNoticeUser;
import com.xuechen.web.bo.AppNoticeUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppNoticeUserMapper {
    int countByExample(AppNoticeUserExample example);

    int deleteByExample(AppNoticeUserExample example);

    int deleteByPrimaryKey(Integer noticeUserId);

    int insert(AppNoticeUser record);

    int insertSelective(AppNoticeUser record);

    List<AppNoticeUser> selectByExample(AppNoticeUserExample example);

    AppNoticeUser selectByPrimaryKey(Integer noticeUserId);

    int updateByExampleSelective(@Param("record") AppNoticeUser record, @Param("example") AppNoticeUserExample example);

    int updateByExample(@Param("record") AppNoticeUser record, @Param("example") AppNoticeUserExample example);

    int updateByPrimaryKeySelective(AppNoticeUser record);

    int updateByPrimaryKey(AppNoticeUser record);
}