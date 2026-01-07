package org.henrikjavayh.springsecurityblackjack.security;

import org.henrikjavayh.springsecurityblackjack.customuser.CustomUser;
import org.henrikjavayh.springsecurityblackjack.customuser.CustomUserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.henrikjavayh.springsecurityblackjack.customuser.Role;


import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final CustomUserRepository customUserRepository;

    public CustomUserDetailsService(CustomUserRepository customUserRepository) {
        this.customUserRepository = customUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        CustomUser customUser = customUserRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                customUser.getUsername(),
                customUser.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + customUser.getRole().name()))
        );
    }
}