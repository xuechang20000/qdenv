package com.xuechen.core.utils.dto;

public class MiniMenuDTO {
    private  int id;
    private int pid;
    private String text;
    private String iconCls;
    private String url;
    private String iconPosition;

    public String getIconPosition() {
        return iconPosition;
    }

    public void setIconPosition(String iconPosition) {
        this.iconPosition = iconPosition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
