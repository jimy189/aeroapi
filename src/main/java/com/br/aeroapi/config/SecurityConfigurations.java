package com.br.aeroapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
   @Autowired
    SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return  httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .requestMatchers(HttpMethod.GET, "/voos").permitAll()
                        .requestMatchers(HttpMethod.PATCH, "/passagem/cancelarcompra").permitAll()
                        .requestMatchers(HttpMethod.PATCH, "/passagem/comprarpassagem").permitAll()
                        .requestMatchers(HttpMethod.GET, "/passagem/compras").permitAll()
                        .requestMatchers(HttpMethod.GET, "/passagem/cpf").permitAll()
                        .requestMatchers(HttpMethod.POST, "/passagem/emitirvoucher").permitAll()
                        .requestMatchers(HttpMethod.POST, "/passagem/emitiretiquetabagagem").permitAll()
                        .requestMatchers(HttpMethod.GET, "/voos").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/voos/passageiro").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/voos").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/voos").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH, "/voos").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/aeroportos").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/passagem/cadastrapassagem").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH, "/passagem/alterarpreco").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/passagem/passageirolistavoo").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/passagem/passagemvoo").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
