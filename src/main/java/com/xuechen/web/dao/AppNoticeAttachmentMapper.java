package com.xuechen.web.dao;

import com.xuechen.web.bo.AppNoticeAttachment;
import com.xuechen.web.bo.AppNoticeAttachmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppNoticeAttachmentMapper {
    int countByExample(AppNoticeAttachmentExample example);

    int deleteByExample(AppNoticeAttachmentExample example);

    int deleteByPrimaryKey(Integer noticeAttachmentId);

    int insert(AppNoticeAttachment record);

    int insertSelective(AppNoticeAttachment record);

    List<AppNoticeAttachment> selectByExample(AppNoticeAttachmentExample example);

    AppNoticeAttachment selectByPrimaryKey(Integer noticeAttachmentId);

    int updateByExampleSelective(@Param("record") AppNoticeAttachment record, @Param("example") AppNoticeAttachmentExample example);

    int updateByExample(@Param("record") AppNoticeAttachment record, @Param("example") AppNoticeAttachmentExample example);

    int updateByPrimaryKeySelective(AppNoticeAttachment record);

    int updateByPrimaryKey(AppNoticeAttachment record);
}