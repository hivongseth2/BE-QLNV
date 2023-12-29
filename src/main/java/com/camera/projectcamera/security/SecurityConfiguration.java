package com.camera.projectcamera.security;

import com.camera.projectcamera.entity.ERole;
import com.camera.projectcamera.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
        corsConfiguration.setAllowedOrigins(List.of("http://127.0.0.1:5501", "http://127.0.0.1:5500", "http://localhost:3000"));
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PUT","OPTIONS","PATCH", "DELETE"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setExposedHeaders(List.of("Authorization"));

        http.cors().configurationSource(request -> corsConfiguration);
        http.csrf(csrf -> csrf.disable());

        http.authorizeHttpRequests(request -> request
//                .requestMatchers("/reset-password").hasAnyAuthority(ERole.ROLE_ADMIN.name(), ERole.ROLE_STAFF.name(), ERole.ROLE_USER.name())
//                .requestMatchers(HttpMethod.GET, "/staff/{id}").hasAnyAuthority(ERole.ROLE_ADMIN.name(), ERole.ROLE_STAFF.name())
//                .requestMatchers("/staff/**").hasAnyAuthority(ERole.ROLE_ADMIN.name())
//                .requestMatchers(HttpMethod.GET, "/booking/list-by-email").permitAll()
//                .requestMatchers(HttpMethod.POST, "/booking").permitAll()
//                .requestMatchers("/booking/**").hasAnyAuthority(ERole.ROLE_STAFF.name(), ERole.ROLE_ADMIN.name())
                .requestMatchers(HttpMethod.GET, "/manager/**").hasAnyAuthority(ERole.MANAGER.name())
//                .requestMatchers("/customer/**").hasAnyAuthority(ERole.ROLE_STAFF.name(), ERole.ROLE_ADMIN.name())
//                .requestMatchers(HttpMethod.GET, "/location", "/location/{id}").permitAll()
//                .requestMatchers("/location/**").hasAnyAuthority(ERole.ROLE_STAFF.name(), ERole.ROLE_ADMIN.name())
//                .requestMatchers(HttpMethod.GET, "/tour", "/tour/{id}").permitAll()
//                .requestMatchers("/tour/**").hasAnyAuthority(ERole.ROLE_STAFF.name(), ERole.ROLE_ QADMIN.name())
//                .requestMatchers(HttpMethod.GET, "/tour-info", "/tour-info/{id}").permitAll()
//                .requestMatchers("/tour-info/**").hasAnyAuthority(ERole.ROLE_STAFF.name(), ERole.ROLE_ADMIN.name())
                .requestMatchers("/**").permitAll()
                .anyRequest().authenticated()
        ).sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.httpBasic(Customizer.withDefaults());

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserService userService) {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService); //set the custom user details service
        auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
        return auth;
    }


}