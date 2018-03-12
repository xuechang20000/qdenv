package com.xuechen.qdenv.bo;

import com.wondersgroup.framwork.dao.annotation.Id;
import com.wondersgroup.framwork.dao.annotation.Table;

import java.util.Date;

@Table(name="wt04")
public class Wt04 {
    private Integer wxt001;

    private Integer bcz001;
    private String bcz002;
    private Integer wct001;

    private Integer wbt001;

    private Double wxt002;

    private String bcz003;

    private Double bcz004;

    private Double bcz005;

    private String bcz006;

    private String bcz008;

    private String wxt003;

    private Double wxt004;

    private Integer wxt005;

    private Date wxt006;
    private String wxt007;
    private String wxt008;
    private String wxt009;

    @Id
    public Integer getWxt001() {
        return wxt001;
    }

    public void setWxt001(Integer wxt001) {
        this.wxt001 = wxt001;
    }

    public Integer getBcz001() {
        return bcz001;
    }

    public void setBcz001(Integer bcz001) {
        this.bcz001 = bcz001;
    }

    public String getBcz002() {
        return bcz002;
    }

    public void setBcz002(String bcz002) {
        this.bcz002 = bcz002;
    }

    public Integer getWct001() {
        return wct001;
    }

    public void setWct001(Integer wct001) {
        this.wct001 = wct001;
    }

    public Integer getWbt001() {
        return wbt001;
    }

    public void setWbt001(Integer wbt001) {
        this.wbt001 = wbt001;
    }

    public Double getWxt002() {
        return wxt002;
    }

    public void setWxt002(Double wxt002) {
        this.wxt002 = wxt002;
    }

    public String getBcz003() {
        return bcz003;
    }

    public void setBcz003(String bcz003) {
        this.bcz003 = bcz003 == null ? null : bcz003.trim();
    }

    public Double getBcz004() {
        return bcz004;
    }

    public void setBcz004(Double bcz004) {
        this.bcz004 = bcz004;
    }

    public Double getBcz005() {
        return bcz005;
    }

    public void setBcz005(Double bcz005) {
        this.bcz005 = bcz005;
    }

    public String getBcz006() {
        return bcz006;
    }

    public void setBcz006(String bcz006) {
        this.bcz006 = bcz006 == null ? null : bcz006.trim();
    }

    public String getBcz008() {
        return bcz008;
    }

    public void setBcz008(String bcz008) {
        this.bcz008 = bcz008 == null ? null : bcz008.trim();
    }

    public String getWxt003() {
        return wxt003;
    }

    public void setWxt003(String wxt003) {
        this.wxt003 = wxt003 == null ? null : wxt003.trim();
    }

    public Double getWxt004() {
        return wxt004;
    }

    public void setWxt004(Double wxt004) {
        this.wxt004 = wxt004;
    }

    public Integer getWxt005() {
        return wxt005;
    }

    public void setWxt005(Integer wxt005) {
        this.wxt005 = wxt005;
    }

    public Date getWxt006() {
        return wxt006;
    }

    public void setWxt006(Date wxt006) {
        this.wxt006 = wxt006;
    }

    public String getWxt007() {
        return wxt007;
    }

    public void setWxt007(String wxt007) {
        this.wxt007 = wxt007;
    }

    public String getWxt008() {
        return wxt008;
    }

    public void setWxt008(String wxt008) {
        this.wxt008 = wxt008;
    }

    public String getWxt009() {
        return wxt009;
    }

    public void setWxt009(String wxt009) {
        this.wxt009 = wxt009;
    }
}