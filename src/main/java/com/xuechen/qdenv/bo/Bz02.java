package com.xuechen.qdenv.bo;

import com.wondersgroup.framwork.dao.annotation.Id;
import com.wondersgroup.framwork.dao.annotation.Table;

@Table(name="bz02")
public class Bz02 {
    private Integer bcz001;

    private Integer bbz001;

    private String bcz002;

    private String bcz003;

    private Double bcz004;

    private Double bcz005;

    private String bcz006;

    private Integer bcz007;

    private String bcz008;

    private String bcz009;

    public Double getBcz010() {
        return bcz010;
    }

    public void setBcz010(Double bcz010) {
        this.bcz010 = bcz010;
    }

    private Double bcz010;
    @Id
    public Integer getBcz001() {
        return bcz001;
    }

    public void setBcz001(Integer bcz001) {
        this.bcz001 = bcz001;
    }

    public Integer getBbz001() {
        return bbz001;
    }

    public void setBbz001(Integer bbz001) {
        this.bbz001 = bbz001;
    }

    public String getBcz002() {
        return bcz002;
    }

    public void setBcz002(String bcz002) {
        this.bcz002 = bcz002 == null ? null : bcz002.trim();
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

    public Integer getBcz007() {
        return bcz007;
    }

    public void setBcz007(Integer bcz007) {
        this.bcz007 = bcz007;
    }

    public String getBcz008() {
        return bcz008;
    }

    public void setBcz008(String bcz008) {
        this.bcz008 = bcz008 == null ? null : bcz008.trim();
    }

    public String getBcz009() {
        return bcz009;
    }

    public void setBcz009(String bcz009) {
        this.bcz009 = bcz009 == null ? null : bcz009.trim();
    }
}