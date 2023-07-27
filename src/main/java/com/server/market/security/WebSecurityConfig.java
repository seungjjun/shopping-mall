package com.server.market.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {
    private final AccessTokenAuthenticationFilter authenticationFilter;

    public WebSecurityConfig(
        AccessTokenAuthenticationFilter authenticationFilter) {
        this.authenticationFilter = authenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
        throws Exception {
        http.cors();
        http.csrf().disable();

        http.addFilterBefore(
            authenticationFilter, BasicAuthenticationFilter.class);

        http.authorizeHttpRequests()
            .requestMatchers(new AntPathRequestMatcher("/session", "POST")).permitAll()
            .requestMatchers(new AntPathRequestMatcher("/users", "POST")).permitAll()
            .requestMatchers(new AntPathRequestMatcher("/categories", "GET")).permitAll()
            .requestMatchers(new AntPathRequestMatcher("/products/**", "GET")).permitAll()
            .requestMatchers(new AntPathRequestMatcher("/backdoor/**", "GET")).permitAll()
            .anyRequest().authenticated();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }
}
