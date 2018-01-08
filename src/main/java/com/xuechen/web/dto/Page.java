package com.xuechen.web.dto;

import java.util.List;

public class Page {
    private int pageSize;
    private int pageIndex;
    private long total;
    private List data;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public Page(long total, List list) {
        this.total=total;
        this.data=list;
    }

    public Page(){}

}
