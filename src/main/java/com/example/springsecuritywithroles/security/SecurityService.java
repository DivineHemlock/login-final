package com.example.springsecuritywithroles.security;

import com.example.springsecuritywithroles.model.User;
import com.example.springsecuritywithroles.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SecurityService implements UserDetailsService {
    private final UserRepository repository;

    public SecurityService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
         User user =  repository.getUserByUsername(s);
        if (user == null) throw new UsernameNotFoundException("no such user exists");
        return new SecurityUser(user);
    }
}
