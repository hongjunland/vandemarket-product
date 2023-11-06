package com.vandemarket.productservice.common.config;

import com.vandemarket.productservice.common.utils.TokenAuthenticationFilter;
import com.vandemarket.productservice.common.utils.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig {
    private final TokenProvider tokenProvider;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
                .httpBasic().disable()
                .authorizeHttpRequests((auth) -> auth
//                        .antMatchers(HttpMethod.POST, "/api/v1/auth/products").permitAll()
                        .antMatchers(HttpMethod.GET, "/api/v1/products", "/api/v1/products/**").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(new TokenAuthenticationFilter(tokenProvider), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (webSecurity) -> webSecurity.ignoring()
                .antMatchers("/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**", "/configuration/ui")
                .antMatchers("/v3/api-docs", "/configuration/ui", "/swagger-resources/**", "/swagger-ui/**",
                        "/configuration/security", "/swagger-ui.html", "/webjars/**", "/swagger/**")
                .antMatchers("/static/css/**, /static/js/**, *.ico")
                .antMatchers("/docs/index.html")
                .antMatchers("/docs/**")
                ;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
