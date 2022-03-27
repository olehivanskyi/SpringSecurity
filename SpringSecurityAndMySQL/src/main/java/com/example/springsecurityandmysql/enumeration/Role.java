package com.example.springsecurityandmysql.enumeration;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER(Set.of(Permission.READ)),
    MODERATOR(Set.of(Permission.READ, Permission.EDIT)),
    ADMIN(Set.of(Permission.READ, Permission.EDIT, Permission.WRITE));

    private final Set<Permission> permissions;

    Role(final Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
