package com.xuechen.qdenv.bo;

import com.wondersgroup.framwork.dao.annotation.Id;
import com.wondersgroup.framwork.dao.annotation.Table;

import java.util.Date;

@Table(name="wt09")
public class Wt09 {
    private Integer wgt001;

    private Integer wat001;

    private Integer wbt001;

    private Integer wct001;

    private Integer wgt002;

    private String wgt003;

    private Date wgt004;

    private String wgt005;

    private String wgt006;

    private String aae013;

    @Id
    public Integer getWgt001() {
        return wgt001;
    }

    public void setWgt001(Integer wgt001) {
        this.wgt001 = wgt001;
    }

    public Integer getWat001() {
        return wat001;
    }

    public void setWat001(Integer wat001) {
        this.wat001 = wat001;
    }

    public Integer getWbt001() {
        return wbt001;
    }

    public void setWbt001(Integer wbt001) {
        this.wbt001 = wbt001;
    }

    public Integer getWct001() {
        return wct001;
    }

    public void setWct001(Integer wct001) {
        this.wct001 = wct001;
    }

    public Integer getWgt002() {
        return wgt002;
    }

    public void setWgt002(Integer wgt002) {
        this.wgt002 = wgt002;
    }

    public String getWgt003() {
        return wgt003;
    }

    public void setWgt003(String wgt003) {
        this.wgt003 = wgt003 == null ? null : wgt003.trim();
    }

    public Date getWgt004() {
        return wgt004;
    }

    public void setWgt004(Date wgt004) {
        this.wgt004 = wgt004;
    }

    public String getWgt005() {
        return wgt005;
    }

    public void setWgt005(String wgt005) {
        this.wgt005 = wgt005 == null ? null : wgt005.trim();
    }

    public String getWgt006() {
        return wgt006;
    }

    public void setWgt006(String wgt006) {
        this.wgt006 = wgt006 == null ? null : wgt006.trim();
    }

    public String getAae013() {
        return aae013;
    }

    public void setAae013(String aae013) {
        this.aae013 = aae013 == null ? null : aae013.trim();
    }
}