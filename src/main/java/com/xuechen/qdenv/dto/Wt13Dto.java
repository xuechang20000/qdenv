package com.xuechen.qdenv.dto;

import java.util.Date;

public class Wt13Dto
{
    private Integer wbt001 ;      //        int not null comment '报告Id',
    private Integer wat001     ;//          int comment '委托ID',
    private String content ; //            blob,
    private Integer userid;//               int,
    private Date ctime;//                datetime,
    private String wat002;

    public String getWat002() {
        return wat002;
    }

    public void setWat002(String wat002) {
        this.wat002 = wat002;
    }

    public Integer getWbt001() {
        return wbt001;
    }

    public void setWbt001(Integer wbt001) {
        this.wbt001 = wbt001;
    }

    public Integer getWat001() {
        return wat001;
    }

    public void setWat001(Integer wat001) {
        this.wat001 = wat001;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}
