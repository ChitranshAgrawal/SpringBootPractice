package com.guchi.simpleWebApp.config;

import com.guchi.simpleWebApp.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity // i don't want default security configuration, i want it here
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtFilter jwtFilter;

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
                .authorizeHttpRequests(request -> request
                .requestMatchers("/register", "/login") // these both requests are permitted without auth
                .permitAll()
                .anyRequest().authenticated()) // and any other requests are authenticated
                // we can comment this above line for practice. it will disable the authentication for frontend

                .httpBasic(Customizer.withDefaults()) // rest api
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // this is for validation
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();

//        http.formLogin(Customizer.withDefaults()); // browser

//        return http.build(); // build returns the object of security filter chain
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        UserDetails user1 = User.withDefaultPasswordEncoder().username("admin").password("admin@123").roles("ADMIN").build();
//        UserDetails user2 = User.withDefaultPasswordEncoder().username("employee").password("emp@123").roles("EMPLOYEE").build();
//        return new InMemoryUserDetailsManager(user1,user2);
//    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setPasswordEncoder(new BCryptPasswordEncoder(10));
        return provider;
    }

    // we have the hold to auth manager and auth manager will talk with auth provider above
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }
}






