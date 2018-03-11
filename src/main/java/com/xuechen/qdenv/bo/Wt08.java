package com.xuechen.qdenv.bo;

import com.wondersgroup.framwork.dao.annotation.Id;
import com.wondersgroup.framwork.dao.annotation.Table;

import java.util.Date;

@Table(name="wt08")
public class Wt08 {
    private Integer wdt001;
    private Integer wat001;
    private Integer userid;

    private String wdt002;
    private String wdt003;
    private Date wdt004;
    private Integer wdt005;
    private String aae013;

    @Id
    public Integer getWdt001() {
        return wdt001;
    }

    public void setWdt001(Integer wdt001) {
        this.wdt001 = wdt001;
    }

    public Integer getWat001() {
        return wat001;
    }

    public void setWat001(Integer wat001) {
        this.wat001 = wat001;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getWdt002() {
        return wdt002;
    }

    public void setWdt002(String wdt002) {
        this.wdt002 = wdt002;
    }

    public String getWdt003() {
        return wdt003;
    }

    public void setWdt003(String wdt003) {
        this.wdt003 = wdt003;
    }

    public Date getWdt004() {
        return wdt004;
    }

    public void setWdt004(Date wdt004) {
        this.wdt004 = wdt004;
    }

    public Integer getWdt005() {
        return wdt005;
    }

    public void setWdt005(Integer wdt005) {
        this.wdt005 = wdt005;
    }

    public String getAae013() {
        return aae013;
    }

    public void setAae013(String aae013) {
        this.aae013 = aae013;
    }
}