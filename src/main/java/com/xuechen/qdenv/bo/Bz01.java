package com.xuechen.qdenv.bo;

import com.wondersgroup.framwork.dao.annotation.Id;
import com.wondersgroup.framwork.dao.annotation.Table;

import java.util.Date;

@Table(name="bz01")
public class Bz01 {
    private Integer bbz001;

    private String bbz002;

    private String bbz003;

    private String bbz004;

    private String bbz005;

    private Date bbz006;

    private  String aae016;
    private String aae013;

    @Id
    public Integer getBbz001() {
        return bbz001;
    }

    public String getAae016() {
        return aae016;
    }

    public void setAae016(String aae016) {
        this.aae016 = aae016;
    }

    public void setBbz001(Integer bbz001) {
        this.bbz001 = bbz001;
    }

    public String getBbz002() {
        return bbz002;
    }

    public void setBbz002(String bbz002) {
        this.bbz002 = bbz002 == null ? null : bbz002.trim();
    }

    public String getBbz003() {
        return bbz003;
    }

    public void setBbz003(String bbz003) {
        this.bbz003 = bbz003 == null ? null : bbz003.trim();
    }

    public String getBbz004() {
        return bbz004;
    }

    public void setBbz004(String bbz004) {
        this.bbz004 = bbz004 == null ? null : bbz004.trim();
    }

    public String getBbz005() {
        return bbz005;
    }

    public void setBbz005(String bbz005) {
        this.bbz005 = bbz005 == null ? null : bbz005.trim();
    }

    public Date getBbz006() {
        return bbz006;
    }

    public void setBbz006(Date bbz006) {
        this.bbz006 = bbz006;
    }

    public String getAae013() {
        return aae013;
    }

    public void setAae013(String aae013) {
        this.aae013 = aae013 == null ? null : aae013.trim();
    }
}