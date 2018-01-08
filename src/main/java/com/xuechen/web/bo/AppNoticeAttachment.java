package com.xuechen.web.bo;

import java.util.Date;

public class AppNoticeAttachment {
    private Integer noticeAttachmentId;

    private Integer noticeId;

    private Date ctime;

    private String url;

    private String filename;

    private String extname;

    public Integer getNoticeAttachmentId() {
        return noticeAttachmentId;
    }

    public void setNoticeAttachmentId(Integer noticeAttachmentId) {
        this.noticeAttachmentId = noticeAttachmentId;
    }

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getExtname() {
        return extname;
    }

    public void setExtname(String extname) {
        this.extname = extname == null ? null : extname.trim();
    }
}