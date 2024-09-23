package com.djungleacademy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(publicPages()).permitAll()
                        .requestMatchers("/private/**").hasRole("Admin")
                        .anyRequest().authenticated()
                )

//                .oauth2Login(oauth2 -> oauth2
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/dashboard", true)
//                        .failureUrl("/login?error=true")
//                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/dashboard", true) // 重定向到 dashboard 页面并保持状态
                        .failureUrl("/login?error=true")
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout=true")
                        .invalidateHttpSession(true)
                )
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private String[] publicPages() {
        return new String[] {
                "/",
                "/home",
                "/holidays/**",
                "/contact",
                "/saveMsg",
                "/courses",
                "/about",
                "/assets/**",
                "/login",
                "/logout",
                "/createUser"
        };
}
}
