package com.tobeto.pair6.rentACar.entities.concretes;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    USER,
    ADMIN,
    GUEST,
    MODERATOR;

    @Override
    public String getAuthority() {
        return name();
    }

}
