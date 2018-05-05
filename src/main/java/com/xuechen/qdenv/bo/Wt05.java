package com.xuechen.qdenv.bo;

import com.wondersgroup.framwork.dao.annotation.Id;
import com.wondersgroup.framwork.dao.annotation.Table;

import java.util.Date;

@Table(name="wt05")
public class Wt05 {
    private Integer wft001;

    private Integer wat001;

    private Double wft002;

    private Double wft003;

    private Double wft004;

    private Double wft005;

    private Double wft006;

    private Double wft007;

    private Double wft008;

    private String wft009;

    private String wft010;

    private Date wft011;

    private String aae013;
    private String wft031;

    @Id
    public Integer getWft001() {
        return wft001;
    }

    public void setWft001(Integer wft001) {
        this.wft001 = wft001;
    }

    public Integer getWat001() {
        return wat001;
    }

    public void setWat001(Integer wat001) {
        this.wat001 = wat001;
    }

    public Double getWft002() {
        return wft002;
    }

    public void setWft002(Double wft002) {
        this.wft002 = wft002;
    }

    public Double getWft003() {
        return wft003;
    }

    public void setWft003(Double wft003) {
        this.wft003 = wft003;
    }

    public Double getWft004() {
        return wft004;
    }

    public void setWft004(Double wft004) {
        this.wft004 = wft004;
    }

    public Double getWft005() {
        return wft005;
    }

    public void setWft005(Double wft005) {
        this.wft005 = wft005;
    }

    public Double getWft006() {
        return wft006;
    }

    public void setWft006(Double wft006) {
        this.wft006 = wft006;
    }

    public Double getWft007() {
        return wft007;
    }

    public void setWft007(Double wft007) {
        this.wft007 = wft007;
    }

    public Double getWft008() {
        return wft008;
    }

    public void setWft008(Double wft008) {
        this.wft008 = wft008;
    }

    public String getWft009() {
        return wft009;
    }

    public void setWft009(String wft009) {
        this.wft009 = wft009 == null ? null : wft009.trim();
    }

    public String getWft010() {
        return wft010;
    }

    public void setWft010(String wft010) {
        this.wft010 = wft010 == null ? null : wft010.trim();
    }

    public Date getWft011() {
        return wft011;
    }

    public void setWft011(Date wft011) {
        this.wft011 = wft011;
    }

    public String getAae013() {
        return aae013;
    }

    public void setAae013(String aae013) {
        this.aae013 = aae013 == null ? null : aae013.trim();
    }

    public String getWft031() {
        return wft031;
    }

    public void setWft031(String wft031) {
        this.wft031 = wft031;
    }
}