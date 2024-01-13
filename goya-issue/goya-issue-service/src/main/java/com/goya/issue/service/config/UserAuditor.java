package com.goya.issue.service.config;

import com.goya.security.utils.SecurityUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * @author limoum0u
 * @date 23/12/28 10:52
 */
@Configuration
public class UserAuditor implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        String username = SecurityUtil.getUsername();
        return Optional.of(username);
    }
}
