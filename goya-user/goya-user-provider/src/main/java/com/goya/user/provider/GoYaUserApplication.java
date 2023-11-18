package com.goya.user.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author limoum0u
 * @date 23/11/18 20:03
 */
@EntityScan({"com.goya.user.model.po", "com.goya.hibernate.model.po"})
@EnableJpaRepositories("com.goya.user.provider")
@EnableJpaAuditing
@SpringBootApplication
@EnableDubbo
@EnableDiscoveryClient
public class GoYaUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoYaUserApplication.class, args);
    }

}
