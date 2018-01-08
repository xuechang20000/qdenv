package com.xuechen.web.bo;

public class AppPermissionType {
    private Integer permissionTypeId;

    private String permissionTypeName;

    private String status;

    public Integer getPermissionTypeId() {
        return permissionTypeId;
    }

    public void setPermissionTypeId(Integer permissionTypeId) {
        this.permissionTypeId = permissionTypeId;
    }

    public String getPermissionTypeName() {
        return permissionTypeName;
    }

    public void setPermissionTypeName(String permissionTypeName) {
        this.permissionTypeName = permissionTypeName == null ? null : permissionTypeName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}