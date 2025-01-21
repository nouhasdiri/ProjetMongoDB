package com.example.miniProjetMongoDB.config;

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
    @Bean
    public SecurityFilterChain defaultFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable()) // Désactiver CSRF (si nécessaire)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/register", "/error", "/login").permitAll() // Autoriser les routes publiques
                        .anyRequest().authenticated()) // Authentification nécessaire pour le reste
                .formLogin(form -> form
                        .loginPage("/login") // Page de connexion personnalisée
                        .defaultSuccessUrl("/users", true) // URL de redirection après succès
                        .failureUrl("/login?error=true") // URL de redirection en cas d'échec
                        .permitAll())
                .logout(logout -> logout.permitAll()) // Permettre à tous de se déconnecter
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

