package com.goya.menu.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author limoum0u
 * @date 23/11/21 22:54
 */
@EntityScan({"com.goya.menu.model.po", "com.goya.hibernate.model.po"})
@EnableJpaRepositories("com.goya.menu.provider.repository")
@EnableJpaAuditing
@SpringBootApplication
@EnableDubbo
@EnableDiscoveryClient
public class GoYaMenuApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoYaMenuApplication.class, args);
    }
}