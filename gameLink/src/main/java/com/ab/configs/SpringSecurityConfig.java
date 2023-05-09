package com.ab.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Configure HTTP security rules
        http.authorizeHttpRequests((requests) -> requests
                // Allow access to specific URLs without authentication
                .requestMatchers("/", "/index", "/register").permitAll()
                // Require authentication for any other request
                .anyRequest().authenticated()
        )
        // Configure form login
        .formLogin((form) -> form
                .loginPage("/login") // Set the login page URL
                .defaultSuccessUrl("/dashboard") // Redirect to "/dashboard" after successful login
                .permitAll() // Allow access to the login page
        );

        // Configure logout
        http.logout()
                .logoutUrl("/logout"); // Set the logout URL

        http.csrf().disable(); // Disable CSRF protection (for simplicity, not recommended in production)

        return http.build(); // Build and return the security filter chain
    }
}

