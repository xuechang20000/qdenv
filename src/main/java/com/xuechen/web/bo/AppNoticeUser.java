package com.xuechen.web.bo;

import java.util.Date;

public class AppNoticeUser {
    private Integer noticeUserId;

    private Integer noticeId;

    private Integer userId;

    private Date noticeReadTime;

    private String noticeIsread;

    public Integer getNoticeUserId() {
        return noticeUserId;
    }

    public void setNoticeUserId(Integer noticeUserId) {
        this.noticeUserId = noticeUserId;
    }

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getNoticeReadTime() {
        return noticeReadTime;
    }

    public void setNoticeReadTime(Date noticeReadTime) {
        this.noticeReadTime = noticeReadTime;
    }

    public String getNoticeIsread() {
        return noticeIsread;
    }

    public void setNoticeIsread(String noticeIsread) {
        this.noticeIsread = noticeIsread == null ? null : noticeIsread.trim();
    }
}