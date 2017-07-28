package org.kitpes.security;

import lombok.NonNull;
import org.kitpes.data.contract.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by mac on 07.07.17.
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return new UserPrincipal(userRepository.findByUsername(username));
    }
}
