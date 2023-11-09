package com.goya.auth.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.goya.*.model.po")
@EnableJpaRepositories("com.goya.auth.provider.repository")
@EnableJpaAuditing
public class GoyaAuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoyaAuthServiceApplication.class, args);
    }

}
