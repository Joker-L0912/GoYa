package com.goya.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.goya.core.constant.CacheConstants;
import com.goya.core.domain.Result;
import com.goya.gateway.config.properties.IgnoreWhiteProperties;
import com.goya.redis.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * @author limoum0u
 * @date 23/11/22 17:09
 */
@Slf4j
@Component
public class AuthFilter implements GlobalFilter, Ordered {

    private final static long EXPIRE_TIME = 60 * 60 * 24 * 7;

    private final AntPathMatcher pathMatcher = new AntPathMatcher();
    // 排除过滤的 uri 地址，nacos自行添加
    private IgnoreWhiteProperties ignoreWhite;

    private RedisUtils redisUtils;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String url = exchange.getRequest().getURI().getPath();
        // 跳过不需要验证的路径
        for (String white : ignoreWhite.getWhites()) {
            if (pathMatcher.match(white, url)) {
                return chain.filter(exchange);
            }
        }
        String token = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (StringUtils.isBlank(token)) {
            return setUnauthorizedResponse(exchange, "令牌不能为空", String.valueOf(HttpStatus.UNAUTHORIZED.value()));
        }
        Boolean tokenExist = redisUtils.hasKey(getTokenKey(token));

        if (!tokenExist) {
            return setUnauthorizedResponse(exchange, "令牌验证失败", String.valueOf(HttpStatus.UNAUTHORIZED.value()));
        }

        //校验用户密码是否已过期
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//        Date parse = null;
//        try {
//            parse = sdf.parse(passwordUpdateDate);
//            DateUtils.
//            int differentDays = DateUtil.daysBetween(parse, new Date());
//            //修改密码接口放行
//            if (UserConstants.MAXEXPIRED <= differentDays && !url.equals("/auth/updateUser")) {
//                return setUnauthorizedResponse(exchange, "您的密码已过期,请重新修改密码",
//                        com.erow.base.common.constant.HttpStatus.PWD_EXPIRED);
//            }
//        } catch (NullPointerException e) {
//            //修改密码接口放行
//            if (parse == null && !url.equals("/auth/updateUser")) {
//                return setUnauthorizedResponse(exchange, "首次登录,请先修改密码！",
//                        com.erow.base.common.constant.HttpStatus.PWD_EXPIRED);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // 设置过期时间
        redisUtils.expire(getTokenKey(token), EXPIRE_TIME, TimeUnit.SECONDS);
        return chain.filter(exchange);
    }

    private Mono<Void> setUnauthorizedResponse(ServerWebExchange exchange, String msg, String code) {
        ServerHttpResponse response = exchange.getResponse();
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);

        log.error("[鉴权异常处理]请求路径:{}", exchange.getRequest().getPath());

        return response.writeWith(Mono.fromSupplier(() -> {
            DataBufferFactory bufferFactory = response.bufferFactory();
            return bufferFactory.wrap(JSON.toJSONBytes(Result.ofFail(code, msg)));
        }));
    }

    private String getTokenKey(String token) {
        return CacheConstants.REDIS_TOKEN_PREFIX + token;
    }

    @Override
    public int getOrder() {
        return -200;
    }

    @Autowired
    public void setIgnoreWhite(IgnoreWhiteProperties ignoreWhite) {
        this.ignoreWhite = ignoreWhite;
    }

    @Autowired
    public void setRedisUtils(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }
}
