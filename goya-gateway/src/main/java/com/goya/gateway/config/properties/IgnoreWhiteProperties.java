package com.goya.gateway.config.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 白名单
 *
 * @author Limou
 * @date 2023/09/27 16:29
 **/
@Data
@NoArgsConstructor
@Configuration
@RefreshScope
@ConfigurationProperties("goya.gateway.ignore")
public class IgnoreWhiteProperties {

    public List<String> whites = new ArrayList<>();

}