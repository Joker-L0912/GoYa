package com.goya.issue.service.config;

import com.goya.redis.utils.RedisUtils;
import com.goya.security.filter.TokenAuthenticationFilter;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author limoum0u
 * @date 23/11/5 23:04
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Resource
    RedisUtils redisUtils;

    @Resource
    TokenAuthenticationFilter tokenAuthenticationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                // 开启跨域以便前端调用接口
                .cors()
                .and()
                .authorizeHttpRequests().requestMatchers("/error", "/**").permitAll()
                .anyRequest().authenticated()
                .and()
                // 基于 token，不需要 session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterAt(tokenAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
