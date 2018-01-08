package com.xuechen.web.dto;

import com.xuechen.web.bo.AppNotice;
import com.xuechen.web.bo.AppNoticeAttachment;

import java.util.Date;
import java.util.List;

public class AppNoticeDTO extends AppNotice {
    private List<AppNoticeAttachment> appNoticeAttachmentList;
    private List<AppNoticeUserDTO> appNoticeUserDTOList;

    public List<AppNoticeUserDTO> getAppNoticeUserDTOList() {
        return appNoticeUserDTOList;
    }

    public void setAppNoticeUserDTOList(List<AppNoticeUserDTO> appNoticeUserDTOList) {
        this.appNoticeUserDTOList = appNoticeUserDTOList;
    }

    public String getNoticeIsread() {
        return noticeIsread;
    }

    public void setNoticeIsread(String noticeIsread) {
        this.noticeIsread = noticeIsread;
    }

    private String noticeIsread;
    private Date noticeReadTime;

    public Date getNoticeReadTime() {
        return noticeReadTime;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNoticeReadTime(Date noticeReadTime) {
        this.noticeReadTime = noticeReadTime;
    }

    public List<AppNoticeAttachment> getAppNoticeAttachmentList() {
        return appNoticeAttachmentList;
    }

    public void setAppNoticeAttachmentList(List<AppNoticeAttachment> appNoticeAttachmentList) {
        this.appNoticeAttachmentList = appNoticeAttachmentList;
    }
}
