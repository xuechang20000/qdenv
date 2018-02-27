package com.xuechen.qdenv.dto;

import com.xuechen.qdenv.bo.Wt02;

import java.util.List;

public class Wt02Dto extends Wt02 {
    private List<Wt03Dto> wt03DtoList;
    private  String idx;
    private String bbz002;
    private String bbz003;
    private String bbz004;
    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }

    public List<Wt03Dto> getWt03DtoList() {
        return wt03DtoList;
    }

    public void setWt03DtoList(List<Wt03Dto> wt03DtoList) {
        this.wt03DtoList = wt03DtoList;
    }

    public String getBbz002() {
        return bbz002;
    }

    public void setBbz002(String bbz002) {
        this.bbz002 = bbz002;
    }

    public String getBbz003() {
        return bbz003;
    }

    public void setBbz003(String bbz003) {
        this.bbz003 = bbz003;
    }

    public String getBbz004() {
        return bbz004;
    }

    public void setBbz004(String bbz004) {
        this.bbz004 = bbz004;
    }
}
