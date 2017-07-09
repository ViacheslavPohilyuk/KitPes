package org.kitpes.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by mac on 07.07.17.
 */
@Data
public class Role implements GrantedAuthority {
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";

    String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String getAuthority() {
        return roleName;
    }
}