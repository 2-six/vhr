package com.example.vhr.config;

import com.example.vhr.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserService userService;

    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginProcessingUrl("/login")
                        .successHandler((req, resp, auth) -> {
                            resp.setContentType("application/json;charset=utf-8");
                            resp.getWriter().write("{\"code\":200,\"msg\":\"登录成功\"}");
                        })
                        .failureHandler((req, resp, ex) -> {
                            resp.setContentType("application/json;charset=utf-8");
                            resp.getWriter().write("{\"code\":401,\"msg\":\"登录失败\"}");
                        })
                );

        return http.build();
    }
}