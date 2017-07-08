package org.kitpes.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by mac on 07.07.17.
 */
public enum Role implements GrantedAuthority {
    ADMIN, USER;

    @Override
    public String getAuthority() {
        return name();
    }
}