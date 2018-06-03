package com.xuechen.qdenv.bo;

import com.wondersgroup.framwork.dao.annotation.Id;
import com.wondersgroup.framwork.dao.annotation.Table;

import java.util.Date;

@Table(name="wt06")
public class Wt06 {
    private Integer wlt001;

    private String wlt002;

    private String wlt003;

    private Integer wlt004;

    private String aae013;

    @Id
    public Integer getWlt001() {
        return wlt001;
    }

    public void setWlt001(Integer wlt001) {
        this.wlt001 = wlt001;
    }

    public String getWlt002() {
        return wlt002;
    }

    public void setWlt002(String wlt002) {
        this.wlt002 = wlt002;
    }

    public String getWlt003() {
        return wlt003;
    }

    public void setWlt003(String wlt003) {
        this.wlt003 = wlt003;
    }

    public Integer getWlt004() {
        return wlt004;
    }

    public void setWlt004(Integer wlt004) {
        this.wlt004 = wlt004;
    }

    public String getAae013() {
        return aae013;
    }

    public void setAae013(String aae013) {
        this.aae013 = aae013;
    }
}