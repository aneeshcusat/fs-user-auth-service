package com.fs.service.auth.security.config;


import com.fs.service.auth.security.jwt.AuthTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig {

    @Autowired
    private ApplicationConfiguration applicationConfiguration;

    @Autowired
    @Qualifier("unauthorizedEntryPoint")
    AuthenticationEntryPoint authEntryPoint;

    @Autowired
    private AuthTokenFilter authTokenFilter;

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public org.springframework.security.authentication.AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      return http.cors().configurationSource(request -> {
            CorsConfiguration cors = new CorsConfiguration();
            cors.setAllowedOrigins(Arrays.asList(applicationConfiguration.getCorsAllowedOrigins()));
            cors.setAllowedMethods(Arrays.asList(applicationConfiguration.getCorsAllowedMethods()));
            cors.setAllowedHeaders(Arrays.asList(applicationConfiguration.getCorsAllowedHeaders()));
            return cors;
        }).and()
                .csrf().disable()
                .formLogin().disable()
                .httpBasic().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
              .antMatchers(HttpMethod.OPTIONS).permitAll()
              .antMatchers("/api/v1/user/**", "/favicon.ico",
                        "/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**", "/webjars/**", "/actuator/**").permitAll()
                .anyRequest().authenticated().and().exceptionHandling()
                .authenticationEntryPoint(authEntryPoint).and()
                .authenticationProvider(authenticationProvider())

                .addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class).build();
    }
}
