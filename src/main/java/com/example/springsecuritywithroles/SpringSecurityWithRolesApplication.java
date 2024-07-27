package com.example.springsecuritywithroles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringSecurityWithRolesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityWithRolesApplication.class, args);
    }

    @Bean
    public PasswordEncoder getEncoder() {
        Map<String, PasswordEncoder> encoderMap = new HashMap<>();
        encoderMap.put("noop", NoOpPasswordEncoder.getInstance());
        encoderMap.put("bcrypt", new BCryptPasswordEncoder());
        return new DelegatingPasswordEncoder("noop", encoderMap);
    }
}
