package com.xuechen.web.dto;

import com.xuechen.web.bo.AppNoticeUser;

public class AppNoticeUserDTO extends AppNoticeUser {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
