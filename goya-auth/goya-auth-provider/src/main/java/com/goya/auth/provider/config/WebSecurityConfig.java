package com.goya.auth.provider.config;

import com.goya.auth.provider.filter.AuthenticationFilter;
import com.goya.auth.provider.service.UserDetailsServiceImpl;
import com.goya.redis.utils.RedisUtils;
import com.goya.security.filter.TokenAuthenticationFilter;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    UserDetailsServiceImpl userDetailsService;

    @Resource
    RedisUtils redisUtils;

    @Resource
    TokenAuthenticationFilter tokenAuthenticationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf((csrf) -> csrf.disable())
                // 开启跨域以便前端调用接口
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(authorizeHttpRequests -> {
                    authorizeHttpRequests.requestMatchers("/error", "/user/login",
                                    "/user/test").permitAll()
                            .requestMatchers("/**").authenticated();
                })
                // 基于 token，不需要 session
                .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterAt(new AuthenticationFilter(authenticationManager(), redisUtils),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterAt(tokenAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return new ProviderManager(daoAuthenticationProvider);
    }
}
