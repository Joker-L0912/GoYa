package com.goya.issue.service;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan({"com.goya.*.model.po"})
@EnableJpaRepositories("com.goya.issue.service.repository")
@EnableJpaAuditing
@EnableDubbo
@EnableDiscoveryClient
public class GoyaIssueServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoyaIssueServiceApplication.class, args);
    }

}
