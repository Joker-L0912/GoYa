package com.goya.interact.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author limoum0u
 * @date 23/12/29 11:10
 */

@SpringBootApplication
@EntityScan({"com.goya.*.model.po"})
@EnableJpaRepositories("com.goya.interact.provider.repository")
@EnableJpaAuditing
@EnableDubbo
@EnableDiscoveryClient
public class GoyaInteractProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoyaInteractProviderApplication.class, args);
    }
}
