package com.xuechen.qdenv.bo;

import com.wondersgroup.framwork.dao.annotation.Id;
import com.wondersgroup.framwork.dao.annotation.Table;

@Table(name="bz06")
public class Bz06 {
    private Integer bmz001;
    private String bmz002;
    private String bmz003;
    private String bmz004 ;
    private String aae016  ;
    private String aae013;

    @Id
    public Integer getBmz001() {
        return bmz001;
    }

    public void setBmz001(Integer bmz001) {
        this.bmz001 = bmz001;
    }

    public String getBmz002() {
        return bmz002;
    }

    public void setBmz002(String bmz002) {
        this.bmz002 = bmz002;
    }

    public String getBmz003() {
        return bmz003;
    }

    public void setBmz003(String bmz003) {
        this.bmz003 = bmz003;
    }

    public String getBmz004() {
        return bmz004;
    }

    public void setBmz004(String bmz004) {
        this.bmz004 = bmz004;
    }

    public String getAae016() {
        return aae016;
    }

    public void setAae016(String aae016) {
        this.aae016 = aae016;
    }

    public String getAae013() {
        return aae013;
    }

    public void setAae013(String aae013) {
        this.aae013 = aae013;
    }
}
