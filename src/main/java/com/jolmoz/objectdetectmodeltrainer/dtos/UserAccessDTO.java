package com.jolmoz.objectdetectmodeltrainer.dtos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserAccessDTO {

    private long id;
    private String userName;
    private String userRole;
    private String userSessionData;
    private String ipAddress;
    private LocalDateTime expiryTime;
    private List<RoleDTO> roles = new ArrayList<RoleDTO>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserSessionData() {
        return userSessionData;
    }

    public void setUserSessionData(String userSessionData) {
        this.userSessionData = userSessionData;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}