package com.goya.security.utils;

import com.goya.security.dto.CustomUser;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author limoum0u
 * @date 23/12/19 23:07
 * <p>
 * Spring Security 工具类
 */
public class SecurityUtil {

    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static String getUsername() {
        return getCustomUser().getUsername();
    }

    public static CustomUser getCustomUser(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomUser) {
            return (CustomUser) principal;
        }
        return null;
    }

    public static CustomUser getCustomUser() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }
        return getCustomUser(authentication);
    }

}
