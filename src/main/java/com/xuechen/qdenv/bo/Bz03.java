package com.xuechen.qdenv.bo;

import com.wondersgroup.framwork.dao.annotation.Id;
import com.wondersgroup.framwork.dao.annotation.Table;

@Table(name="bz03")
public class Bz03 {
    private Integer bzz001;

    private Integer bbz001;

    private String bzz002;

    private String bzz003;

    @Id
    public Integer getBzz001() {
        return bzz001;
    }

    public void setBzz001(Integer bzz001) {
        this.bzz001 = bzz001;
    }

    public Integer getBbz001() {
        return bbz001;
    }

    public void setBbz001(Integer bbz001) {
        this.bbz001 = bbz001;
    }

    public String getBzz002() {
        return bzz002;
    }

    public void setBzz002(String bzz002) {
        this.bzz002 = bzz002 == null ? null : bzz002.trim();
    }

    public String getBzz003() {
        return bzz003;
    }

    public void setBzz003(String bzz003) {
        this.bzz003 = bzz003 == null ? null : bzz003.trim();
    }
}