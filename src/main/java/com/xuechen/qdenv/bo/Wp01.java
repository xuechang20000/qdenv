package com.xuechen.qdenv.bo;

import com.wondersgroup.framwork.dao.annotation.Id;
import com.wondersgroup.framwork.dao.annotation.Table;

import java.util.Date;

@Table(name="wp01")
public class Wp01 {
    private Integer wtp001 ;//              int not null comment '照片ID',
    private String  wtp002   ;//             varchar(6) comment '业务类型',
    private String  wtp003 ;//               int comment '业务ID',
    private Date wtp004   ;//             datetime comment '上传时间',
    private Integer  userid  ;//              int comment '上传人',
    private String  wtp005 ;//               varchar(100) comment '照片url',
    private String  wtp006 ;//               varchar(50) comment '照片名称',
    private String  wtp007 ;//               varchar(20) comment '照片扩展名',
@Id
    public Integer getWtp001() {
        return wtp001;
    }

    public void setWtp001(Integer wtp001) {
        this.wtp001 = wtp001;
    }

    public String getWtp002() {
        return wtp002;
    }

    public void setWtp002(String wtp002) {
        this.wtp002 = wtp002;
    }

    public String getWtp003() {
        return wtp003;
    }

    public void setWtp003(String wtp003) {
        this.wtp003 = wtp003;
    }

    public Date getWtp004() {
        return wtp004;
    }

    public void setWtp004(Date wtp004) {
        this.wtp004 = wtp004;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getWtp005() {
        return wtp005;
    }

    public void setWtp005(String wtp005) {
        this.wtp005 = wtp005;
    }

    public String getWtp006() {
        return wtp006;
    }

    public void setWtp006(String wtp006) {
        this.wtp006 = wtp006;
    }

    public String getWtp007() {
        return wtp007;
    }

    public void setWtp007(String wtp007) {
        this.wtp007 = wtp007;
    }
}
