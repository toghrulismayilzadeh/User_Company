package com.example.task_clone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity security) throws Exception{
        return security.authorizeHttpRequests(reg->{
            reg.requestMatchers(HttpMethod.GET).permitAll();
            reg.requestMatchers(HttpMethod.POST).permitAll();
            reg.requestMatchers(HttpMethod.DELETE).permitAll();
            reg.requestMatchers(HttpMethod.POST).permitAll();
        }).csrf(AbstractHttpConfigurer::disable)
                .build();
    }
}
