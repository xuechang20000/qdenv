package com.xuechen.qdenv.bo;

import com.wondersgroup.framwork.dao.annotation.Id;
import com.wondersgroup.framwork.dao.annotation.Table;

import java.util.Date;

@Table(name="wt11")
public class Wt11 {
    private Integer wrt001 ;//              int not null comment '记录ID',
    private Integer wct001;//               int comment '采样点ID',
    private Integer wxt001   ;//            int comment '实检测项目ID',
    private String wrt002       ;//        varchar(50) comment '检测步骤名称',
    private String wrt003          ;//     varchar(1) comment '阴阳性',
    private String wrt004             ;//  varchar(200) comment '检测值',
    private String wrt005              ;// varchar(20) comment '结果值',
    private Date wrt006               ;//datetime comment '录入时间',
    private Integer wrt007 ;//              int comment '录入 人',
    private Integer wst001 ;//              int comment '样品ID',
    private String  aae013 ;//              varchar(200) comment '备注',
    private Integer wrt008;

    public Integer getWrt008() {
        return wrt008;
    }

    public void setWrt008(Integer wrt008) {
        this.wrt008 = wrt008;
    }

    @Id
    public Integer getWrt001() {
        return wrt001;
    }

    public void setWrt001(Integer wrt001) {
        this.wrt001 = wrt001;
    }

    public Integer getWct001() {
        return wct001;
    }

    public void setWct001(Integer wct001) {
        this.wct001 = wct001;
    }

    public Integer getWxt001() {
        return wxt001;
    }

    public void setWxt001(Integer wxt001) {
        this.wxt001 = wxt001;
    }

    public String getWrt002() {
        return wrt002;
    }

    public void setWrt002(String wrt002) {
        this.wrt002 = wrt002;
    }

    public String getWrt003() {
        return wrt003;
    }

    public void setWrt003(String wrt003) {
        this.wrt003 = wrt003;
    }

    public String getWrt004() {
        return wrt004;
    }

    public void setWrt004(String wrt004) {
        this.wrt004 = wrt004;
    }

    public String getWrt005() {
        return wrt005;
    }

    public void setWrt005(String wrt005) {
        this.wrt005 = wrt005;
    }

    public Date getWrt006() {
        return wrt006;
    }

    public void setWrt006(Date wrt006) {
        this.wrt006 = wrt006;
    }

    public Integer getWrt007() {
        return wrt007;
    }

    public void setWrt007(Integer wrt007) {
        this.wrt007 = wrt007;
    }

    public Integer getWst001() {
        return wst001;
    }

    public void setWst001(Integer wst001) {
        this.wst001 = wst001;
    }

    public String getAae013() {
        return aae013;
    }

    public void setAae013(String aae013) {
        this.aae013 = aae013;
    }
}
