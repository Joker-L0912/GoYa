package com.goya.auth.provider.filter;

import com.goya.auth.model.dto.CustomUser;
import com.goya.core.utils.JsonUtils;
import com.goya.redis.utils.RedisUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.goya.core.constant.CacheConstants.REDIS_TOKEN_PREFIX;
import static com.goya.core.constant.Constants.TOKEN_HEADER;

/**
 * @author limoum0u
 * @date 23/11/7 16:04
 */
@Component
public class TokenAuthenticationFilter extends OncePerRequestFilter {
    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private RedisUtils redisUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(TOKEN_HEADER);

        if (token != null && !token.isEmpty()) {
            String s = redisUtils.get(REDIS_TOKEN_PREFIX + token);
            CustomUser customUser = JsonUtils.parseObject(s, CustomUser.class);
            // 根据token获取用户信息

            if (customUser != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                // 创建一个认证令牌
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(customUser, null, customUser.getAuthorities());
                // 将认证令牌设置到SecurityContextHolder中
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                // 更新 redis key 过期时间
                redisUtils.expire(REDIS_TOKEN_PREFIX + token, 60 * 60 * 24 * 7, TimeUnit.SECONDS);
            }
        }
        filterChain.doFilter(request, response);
    }
}
