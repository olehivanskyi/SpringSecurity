package com.example.springsecurityandmysql.enumeration;

public enum Permission {
    READ("read"),
    WRITE("write"),
    EDIT("write");

    private String permission;

    Permission(final String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
