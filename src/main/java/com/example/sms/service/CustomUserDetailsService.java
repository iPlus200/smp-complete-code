package com.example.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.example.sms.entity.User;
import com.example.sms.repository.UserRepository;

import exception.NotFoundException;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private final UserRepository repo;

    public CustomUserDetailsService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getRole())  
                .build();
    }
    
}
