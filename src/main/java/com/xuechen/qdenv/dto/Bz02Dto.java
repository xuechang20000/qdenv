package com.xuechen.qdenv.dto;

import com.xuechen.qdenv.bo.Bz02;

public class Bz02Dto extends Bz02 {
    private Integer rowIndex;

    public String getBcz0045() {
        return bcz0045;
    }

    public void setBcz0045(String bcz0045) {
        this.bcz0045 = bcz0045;
    }

    private String bcz0045;
    public Integer getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }
}
