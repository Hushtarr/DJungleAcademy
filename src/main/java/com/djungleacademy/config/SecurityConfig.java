package com.djungleacademy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.csrf((csrf) -> csrf.disable())
                        .authorizeHttpRequests(requests ->
                        requests.requestMatchers("/", "/home").permitAll()
                                .requestMatchers("/dashboard").authenticated()
                                .requestMatchers("/holidays/**").permitAll()
                                .requestMatchers("/contact").permitAll()
                                .requestMatchers("/saveMsg").permitAll()
                                .requestMatchers("/courses").authenticated()
                                .requestMatchers("/about").permitAll()
                                .requestMatchers("/assets/**").permitAll()
                                .requestMatchers("/login").permitAll()
                )
                .formLogin(loginConfigurer ->
                        loginConfigurer.loginPage("/login")
                                .defaultSuccessUrl("/dashboard")
                                .failureUrl("/login?error=true")
                                .permitAll()
                )
                .logout(logoutConfigurer ->
                        logoutConfigurer.logoutSuccessUrl("/login?logout=true")
                                .invalidateHttpSession(true)
                                .permitAll()
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();

    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("123")
                .roles("USER")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("123")
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

}