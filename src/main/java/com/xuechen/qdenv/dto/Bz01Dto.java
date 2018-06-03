package com.xuechen.qdenv.dto;

import com.xuechen.qdenv.bo.Bz01;

import java.util.List;

public class Bz01Dto extends Bz01 {
    private String[] bhz001s;
    private List<Bz02Dto> list;
    private String idx;
    private String bzh002s;
    private String bhz001i;
    private String bhz001ss;
    private Integer wat001;
    public String getBzh002s() {
        return bzh002s;
    }

    public void setBzh002s(String bzh002s) {
        this.bzh002s = bzh002s;
    }

    public String getBhz001i() {
        return bhz001i;
    }

    public void setBhz001i(String bhz001i) {
        this.bhz001i = bhz001i;
    }

    public String getBhz001ss() {
        return bhz001ss;
    }

    public void setBhz001ss(String bhz001ss) {
        this.bhz001ss = bhz001ss;
    }

    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }

    public List<Bz02Dto> getList() {
        return list;
    }

    public void setList(List<Bz02Dto> list) {
        this.list = list;
    }

    public String[] getBhz001s() {
        return bhz001s;
    }

    public void setBhz001s(String[] bhz001s) {
        this.bhz001s = bhz001s;
    }

    public Integer getWat001() {
        return wat001;
    }

    public void setWat001(Integer wat001) {
        this.wat001 = wat001;
    }
}
