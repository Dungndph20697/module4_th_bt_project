package com.codegym.bt_spring_security_phan_quyen.service;

import com.codegym.bt_spring_security_phan_quyen.model.User;
import com.codegym.bt_spring_security_phan_quyen.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> findAll() {
        List<User> userDTOS = new ArrayList<>();

        return userDTOS;
    }

    public Optional<User> findById(Long id) {
        Optional<User> user = iUserRepository.findById(id);
        return user;
    }

    public User findByUsername(String username) {
        return iUserRepository.findByUsername(username);
    }

    public boolean add(User user) {
        String passwordEncode = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncode);
        iUserRepository.save(user);
        return true;
    }

    public UserDetails loadUserByUsername(String username) {
        User user = iUserRepository.findByUsername(username);
        Set<GrantedAuthority> authorities = user.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }

}
