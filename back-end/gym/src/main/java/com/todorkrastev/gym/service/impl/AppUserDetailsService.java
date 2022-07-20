package com.todorkrastev.gym.service.impl;

import com.todorkrastev.gym.model.entity.Role;
import com.todorkrastev.gym.model.entity.User;
import com.todorkrastev.gym.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.
                findByUsername(username)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " not found!"));
    }

    private UserDetails map(User user) {
        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(user.
                        getRoles()
                        .stream()
                        .map(this::map)
                        .toList())
                .build();
    }

    private GrantedAuthority map(Role role) {
        return new SimpleGrantedAuthority("ROLE_" + role.getRole().name());
    }
}
