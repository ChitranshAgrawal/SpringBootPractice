package com.guchi.simpleWebApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity // i don't want default security configuration, i want it here
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//        http.csrf(customizer -> customizer.disable()); // disable csrf
//        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
////        http.formLogin(Customizer.withDefaults()); // browser
//        http.httpBasic(Customizer.withDefaults()); // rest api
//        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        // builder pattern
        return http
                .csrf(customizer -> customizer.disable()) // disable csrf
//                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                // we can comment this above line for practice. it will disable the authentication for frontend

                .httpBasic(Customizer.withDefaults()) // rest api
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();

//        http.formLogin(Customizer.withDefaults()); // browser

//        return http.build(); // build returns the object of security filter chain
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new InMemoryUserDetailsManager();
//    }
}




