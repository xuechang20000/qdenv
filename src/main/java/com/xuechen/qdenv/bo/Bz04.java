package com.xuechen.qdenv.bo;

import com.wondersgroup.framwork.dao.annotation.Id;
import com.wondersgroup.framwork.dao.annotation.Table;

@Table(name="bz04")
public class Bz04 {
    private Integer bhz001;

    private String bzh002;

    private  String aae016;

    public String getAae016() {
        return aae016;
    }

    public void setAae016(String aae016) {
        this.aae016 = aae016;
    }

    private String aae013;

    @Id
    public Integer getBhz001() {
        return bhz001;
    }

    public void setBhz001(Integer bhz001) {
        this.bhz001 = bhz001;
    }

    public String getBzh002() {
        return bzh002;
    }

    public void setBzh002(String bzh002) {
        this.bzh002 = bzh002 == null ? null : bzh002.trim();
    }

    public String getAae013() {
        return aae013;
    }

    public void setAae013(String aae013) {
        this.aae013 = aae013 == null ? null : aae013.trim();
    }
}