package com.goya.hibernate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * @author limoum0u
 * @date 23/11/9 23:01
 */
@Configuration
public class UserAuditor implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("lizihan");
    }
}
