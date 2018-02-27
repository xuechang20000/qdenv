package com.xuechen.qdenv.dto;

import com.xuechen.qdenv.bo.Wt03;

import java.util.List;

public class Wt03Dto extends Wt03 {
    private String idx;
    private String bcz002s;
    private String bcz001s;

    private List<Wt04Dto> wt04DtoList;
    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }

    public String getBcz002s() {
        return bcz002s;
    }

    public void setBcz002s(String bcz002s) {
        this.bcz002s = bcz002s;
    }

    public String getBcz001s() {
        return bcz001s;
    }

    public void setBcz001s(String bcz001s) {
        this.bcz001s = bcz001s;
    }

    public List<Wt04Dto> getWt04DtoList() {
        return wt04DtoList;
    }

    public void setWt04DtoList(List<Wt04Dto> wt04DtoList) {
        this.wt04DtoList = wt04DtoList;
    }
}
