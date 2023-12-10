package com.jolmoz.objectdetectmodeltrainer.dtos;

import java.time.LocalDateTime;

public class PermissionRoleDTO {
    private AllowedPermissions permissionDescription;
    private String creationUser;
    private String modifiedBy;
    private String project;
    private LocalDateTime importDate;
    private LocalDateTime modifiedDate;
    private long id;

    public enum AllowedPermissions {
        BATCH_OPERATOR, BATCH_SUPERVISOR, BATCH_ADMIN, PROJECT_ADMIN, EXPORT_ADMIN, REPORT_ADMIN, USER_ADMIN,
        SESSION_ADMIN
    }

    public AllowedPermissions getPermissionDescription() {
        return permissionDescription;
    }

    public void setPermissionDescription(AllowedPermissions permissionDescription) {
        this.permissionDescription = permissionDescription;
    }

    public String getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getImportDate() {
        return importDate;
    }

    public void setImportDate(LocalDateTime importDate) {
        this.importDate = importDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
