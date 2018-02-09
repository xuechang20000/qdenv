package com.xuechen.qdenv.dto;

import com.xuechen.qdenv.bo.Bz01;

import java.util.List;

public class Bz01Dto extends Bz01 {
    private String[] bhz001s;
    private List<Bz02Dto> list;

    public String getBzh002s() {
        return bzh002s;
    }

    public void setBzh002s(String bzh002s) {
        this.bzh002s = bzh002s;
    }

    private  String bzh002s;


    public String getBhz001i() {
        return bhz001i;
    }

    public void setBhz001i(String bhz001i) {
        this.bhz001i = bhz001i;
    }

    private  String bhz001i;
    public String getBhz001ss() {
        return bhz001ss;
    }

    public void setBhz001ss(String bhz001ss) {
        this.bhz001ss = bhz001ss;
    }

    private  String bhz001ss;
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
}
