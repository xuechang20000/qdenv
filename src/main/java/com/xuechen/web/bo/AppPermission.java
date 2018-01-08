package com.xuechen.web.bo;

public class AppPermission {
    private Integer permissionId;

    private Integer permissionResourceId;

    private String permissionType;

    private String status;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getPermissionResourceId() {
        return permissionResourceId;
    }

    public void setPermissionResourceId(Integer permissionResourceId) {
        this.permissionResourceId = permissionResourceId;
    }

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType == null ? null : permissionType.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}