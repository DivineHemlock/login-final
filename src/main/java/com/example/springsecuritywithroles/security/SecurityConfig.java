package com.example.springsecuritywithroles.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final SecurityService securityService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(SecurityService securityService, PasswordEncoder passwordEncoder) {
        this.securityService = securityService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
//        http.formLogin().loginPage("/login");
        http.formLogin().loginProcessingUrl("/login");
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new CustomAuthenticationFilter(authenticationManagerBean()));
        http.addFilterBefore(new CustomAuthorizationFilter() , UsernamePasswordAuthenticationFilter.class);
//        http.authorizeRequests().anyRequest().permitAll();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.csrf().disable();
        http.logout().permitAll();
        // cors config :
        // if allowed credentials is true : we should give exact origin address in allowed origins
        // if allowed credentials is false : we can give patterns for allowed origins, for example "*"
//        http.cors(request -> {
//            CorsConfigurationSource ccs = x -> {
//                CorsConfiguration corsConfiguration = new CorsConfiguration();
//                corsConfiguration.setAllowedOrigins(List.of("*"));
//                corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PUT", "OPTIONS", "PATCH", "DELETE"));
//                corsConfiguration.setAllowCredentials(false);
//                corsConfiguration.setAllowedHeaders(List.of("Content-Type", "Authorization", "Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Headers", "accessToken", "refreshToken", "role", "Access-Control-Allow-Methods", "Access-Control-Allow-Method"));
//                corsConfiguration.setExposedHeaders(List.of("Content-Type", "Authorization", "accessToken", "refreshToken", "role", "Access-Control-Allow-Methods", "Access-Control-Allow-Headers", "Access-Control-Allow-Method"));
//                return corsConfiguration;
//            };
//            request.configurationSource(ccs);
//        });
    }
}
