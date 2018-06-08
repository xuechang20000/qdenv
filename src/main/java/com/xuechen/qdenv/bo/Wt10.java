package com.xuechen.qdenv.bo;

import com.wondersgroup.framwork.dao.annotation.Id;
import com.wondersgroup.framwork.dao.annotation.Table;

import java.util.Date;

@Table(name="wt10")
public class Wt10 {
   private Integer wst001;//               int not null comment '样品ID',
    private Integer wct001;
   private String  wst002;//               varchar(2) comment '样品包装类型',
    private String  wst003  ;//             varchar(50) comment '样品编号',
    private String  wst004     ;//          varchar(50) comment '采样时间起',
    private String  wst005        ;//       varchar(50) comment '采样时间止',
    private String wst006           ;//    varchar(50) comment '采样设备',
    private String  wst007          ;//     varchar(50) comment '采样设备编码',
    private String  wst008           ;//    varchar(50) comment '录入时间',
    private Integer wst009            ;//   int comment '录入人',
    private String wst010;
    private String  aae013             ;//  varchar(200) comment '备注',

    @Id
    public Integer getWst001() {
        return wst001;
    }

    public void setWst001(Integer wst001) {
        this.wst001 = wst001;
    }

    public String getWst002() {
        return wst002;
    }

    public void setWst002(String wst002) {
        this.wst002 = wst002;
    }

    public String getWst003() {
        return wst003;
    }

    public void setWst003(String wst003) {
        this.wst003 = wst003;
    }

    public String getWst004() {
        return wst004;
    }

    public void setWst004(String wst004) {
        this.wst004 = wst004;
    }

    public String getWst005() {
        return wst005;
    }

    public void setWst005(String wst005) {
        this.wst005 = wst005;
    }

    public String getWst006() {
        return wst006;
    }

    public void setWst006(String wst006) {
        this.wst006 = wst006;
    }

    public String getWst007() {
        return wst007;
    }

    public void setWst007(String wst007) {
        this.wst007 = wst007;
    }

    public String getWst008() {
        return wst008;
    }

    public void setWst008(String wst008) {
        this.wst008 = wst008;
    }

    public Integer getWst009() {
        return wst009;
    }

    public void setWst009(Integer wst009) {
        this.wst009 = wst009;
    }

    public String getAae013() {
        return aae013;
    }

    public void setAae013(String aae013) {
        this.aae013 = aae013;
    }

    public Integer getWct001() {
        return wct001;
    }

    public void setWct001(Integer wct001) {
        this.wct001 = wct001;
    }

    public String getWst010() {
        return wst010;
    }

    public void setWst010(String wst010) {
        this.wst010 = wst010;
    }
}