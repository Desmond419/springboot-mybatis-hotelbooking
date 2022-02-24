package com.desmond.HotelManagement.config.jwt;

import com.desmond.HotelManagement.config.jwt.JwtTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class JwtSecurityConfig implements WebMvcConfigurer {
    private final JwtTokenFilter tokenInterceptor;

    public JwtSecurityConfig(JwtTokenFilter tokenInterceptor){
        this.tokenInterceptor = tokenInterceptor;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Other than login and register API path, JWT token is required.
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        List<String> excludePath = new ArrayList<>();
        excludePath.add("/api/auth/login");
        excludePath.add("/api/register");
        excludePath.add("/static/**");
        excludePath.add("/assets/**");

        registry.addInterceptor(tokenInterceptor).addPathPatterns("/**")
                .excludePathPatterns(excludePath);
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
