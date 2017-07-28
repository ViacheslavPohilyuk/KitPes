package org.kitpes.security;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by mac on 18.07.17.
 */
public class AuthenticatedUserIdRetriever {
    public long getId() {
        return ((UserPrincipal) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal()).getUser().getId();
    }
}
