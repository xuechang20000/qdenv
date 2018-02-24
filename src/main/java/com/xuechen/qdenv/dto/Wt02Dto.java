package com.xuechen.qdenv.dto;

import com.xuechen.qdenv.bo.Wt02;

import java.util.List;

public class Wt02Dto extends Wt02 {
    private List<Wt03Dto> wt03DtoList;
    private  String idx;

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
}
