package com.example.spring_security_basics.model;

public enum Permission {
    EMPLOYEES_READ("employees:read"),
    EMPLOYEES_WRITE("employees:write");
    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
