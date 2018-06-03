package com.xuechen.qdenv.dto;

import com.xuechen.qdenv.bo.Wt08;

public class Wt08Dto extends Wt08 {
    private String wat004;
    private String aae013;
    private String wat002;

    public String getWat002() {
        return wat002;
    }

    public void setWat002(String wat002) {
        this.wat002 = wat002;
    }

    public String getWat004() {
        return wat004;
    }

    public void setWat004(String wat004) {
        this.wat004 = wat004;
    }

    @Override
    public String getAae013() {
        return aae013;
    }

    @Override
    public void setAae013(String aae013) {
        this.aae013 = aae013;
    }
}
