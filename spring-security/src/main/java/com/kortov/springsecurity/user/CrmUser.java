package com.kortov.springsecurity.user;

import javax.validation.constraints.NotBlank;

public class CrmUser {
    @NotBlank(message = "is required")
    private String userName;

    @NotBlank(message = "is required")
    private String password;

    public CrmUser() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
