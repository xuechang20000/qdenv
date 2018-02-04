package com.xuechen.qdenv.bo;

import com.wondersgroup.framwork.dao.annotation.Id;
import com.wondersgroup.framwork.dao.annotation.Table;

@Table(name = "bz05")
public class Bz05 {
    private  Integer bdz001;
    private  Integer bhz001;
    private  Integer bbz001;
@Id
    public Integer getBdz001() {
        return bdz001;
    }

    public void setBdz001(Integer bdz001) {
        this.bdz001 = bdz001;
    }

    public Integer getBhz001() {
        return bhz001;
    }

    public void setBhz001(Integer bhz001) {
        this.bhz001 = bhz001;
    }

    public Integer getBbz001() {
        return bbz001;
    }

    public void setBbz001(Integer bbz001) {
        this.bbz001 = bbz001;
    }
}
