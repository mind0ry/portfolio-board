package com.example.demo.post.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // CSRF 보호 끔 (테스트 용도)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/",
                                "/posts/**",
                                "/upload/**",         // 이미지 파일
                                "/css/**", "/js/**", "/images/**", // 정적 리소스
                                "/api/**"
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.disable()) // 로그인 폼 비활성화 (없으면 403 방지)
                .httpBasic(httpBasic -> httpBasic.disable()); // Basic 인증도 비활성화
        return http.build();
    }
}
