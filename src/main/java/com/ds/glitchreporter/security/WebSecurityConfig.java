package com.ds.glitchreporter.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ds.glitchreporter.security.jwt.AuthEntryPointJwt;
import com.ds.glitchreporter.security.jwt.AuthTokenFilter;
import com.ds.glitchreporter.security.services.UserDetailsServiceImpl;
import com.ds.glitchreporter.services.PriorityService;
import com.ds.glitchreporter.services.StatusService;
import com.ds.glitchreporter.services.TopicService;

/**
 * Configuration class for setting up web security.
 */

@Configuration
@EnableMethodSecurity
// (securedEnabled = true,
// jsr250Enabled = true,
// prePostEnabled = true) // by default
public class WebSecurityConfig { // extends WebSecurityConfigurerAdapter {
  @Autowired
  UserDetailsServiceImpl userDetailsService;

  @Autowired
  private AuthEntryPointJwt unauthorizedHandler;

  /**
   * Creates and configures the authentication token filter.
   * @return An instance of AuthTokenFilter
   */
  
  @Bean
  public AuthTokenFilter authenticationJwtTokenFilter() {
    return new AuthTokenFilter();
  }

  /**
   * Creates and configures the authentication provider.
   * @return An instance of DaoAuthenticationProvider
   */
  
  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
       
      authProvider.setUserDetailsService(userDetailsService);
      authProvider.setPasswordEncoder(passwordEncoder());
   
      return authProvider;
  }
  
  /**
   * Creates and configures the authentication manager.
   * @param authConfig The AuthenticationConfiguration
   * @return An instance of AuthenticationManager
   * @throws Exception If there is an error creating the AuthenticationManager
   */
  
  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
    return authConfig.getAuthenticationManager();
  }
  
  /**
   * Creates and configures the password encoder.
   * @return An instance of PasswordEncoder
   */

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
  /**
   * Configures the security filter chain.
   * @param http The HttpSecurity object to configure
   * @return The configured security filter chain
   * @throws Exception If there is an error configuring the security filter chain
   */
  
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())
        .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth -> 
          auth.requestMatchers("/api/auth/**").permitAll()
              .requestMatchers("/api/users/**").permitAll()
              .requestMatchers("/api/metadata/**").permitAll()
              .requestMatchers("/api/ticket/**").permitAll()
              .anyRequest().authenticated()
        );
    
    http.authenticationProvider(authenticationProvider());

    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    
    return http.build();
  }
}