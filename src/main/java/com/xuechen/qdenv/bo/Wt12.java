package com.xuechen.qdenv.bo;

import com.wondersgroup.framwork.dao.annotation.Id;
import com.wondersgroup.framwork.dao.annotation.Table;

import java.sql.Blob;
import java.util.Date;

@Table(name = "wt12")
public class Wt12 {
    private Integer wlt001;//               int not null comment '流转单ID',
    private Integer wat001;//               int not null comment '委托ID',
    private String wlt002;//               varchar(20) comment '流转单编号',
    private Blob wlt003               ;//blob comment '内容',
    private Integer wlt004 ;//              int comment '生成人',
    private String wlt005  ;//             varchar(2) comment '是否生成',
    private Date wlt006              ;// datetime comment '生成时间',
    private String wlt007   ;//            varchar(2) comment '是否打印',
    private Integer wlt008    ;//           int comment '打印人',
    private Date wlt009               ;//datetime comment '打印时间',
    private Integer  wlt010 ;//              int comment '打印次数',

    @Id
    public Integer getWlt001() {
        return wlt001;
    }

    public void setWlt001(Integer wlt001) {
        this.wlt001 = wlt001;
    }

    public Integer getWat001() {
        return wat001;
    }

    public void setWat001(Integer wat001) {
        this.wat001 = wat001;
    }

    public String getWlt002() {
        return wlt002;
    }

    public void setWlt002(String wlt002) {
        this.wlt002 = wlt002;
    }

    public Blob getWlt003() {
        return wlt003;
    }

    public void setWlt003(Blob wlt003) {
        this.wlt003 = wlt003;
    }

    public Integer getWlt004() {
        return wlt004;
    }

    public void setWlt004(Integer wlt004) {
        this.wlt004 = wlt004;
    }

    public String getWlt005() {
        return wlt005;
    }

    public void setWlt005(String wlt005) {
        this.wlt005 = wlt005;
    }

    public Date getWlt006() {
        return wlt006;
    }

    public void setWlt006(Date wlt006) {
        this.wlt006 = wlt006;
    }

    public String getWlt007() {
        return wlt007;
    }

    public void setWlt007(String wlt007) {
        this.wlt007 = wlt007;
    }

    public Integer getWlt008() {
        return wlt008;
    }

    public void setWlt008(Integer wlt008) {
        this.wlt008 = wlt008;
    }

    public Date getWlt009() {
        return wlt009;
    }

    public void setWlt009(Date wlt009) {
        this.wlt009 = wlt009;
    }

    public Integer getWlt010() {
        return wlt010;
    }

    public void setWlt010(Integer wlt010) {
        this.wlt010 = wlt010;
    }
}
