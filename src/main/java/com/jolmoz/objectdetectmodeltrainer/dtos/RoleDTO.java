package com.jolmoz.objectdetectmodeltrainer.dtos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class RoleDTO {
    private long id;
    private String roleName;
    private String creationUser;
    private String modifiedBy;
    private LocalDateTime importDate;
    private LocalDateTime modifiedDate;
    private List<PermissionRoleDTO> permissions = new ArrayList<>();

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public List<PermissionRoleDTO> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionRoleDTO> permissions) {
        this.permissions = permissions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
