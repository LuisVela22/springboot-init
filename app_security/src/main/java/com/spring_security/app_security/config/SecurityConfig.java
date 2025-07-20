package com.spring_security.app_security.config;

// import java.beans.Customizer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
// import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                // .csrf(csrf -> csrf.disable()) // solo si decides desactivarlo
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/secure/public").permitAll()
                        // .requestMatchers("/api/secure/admin").hasRole("ADMIN")
                        // .requestMatchers("/api/secure/user").hasRole("USER")
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .successHandler(successHandler())
                        .permitAll())
                // .permitAll()
                .build();

        // return http.build();
    }

    public AuthenticationSuccessHandler successHandler() {
        return ((request, response, authentication) -> {
            response.sendRedirect("/api/secure/admin");
        });
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("luis")
                .password(passwordEncoder().encode("1234"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("admmin123"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
