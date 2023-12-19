package com.goya.security.utils;

import com.goya.auth.model.dto.CustomUser;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author limoum0u
 * @date 23/12/19 23:07
 * <p>
 * Spring Security 工具类
 */
public class SecurityUtil {

    /**
     * 获取当前登录用户
     *
     * @return
     */
    public static String getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof CustomUser) {
            return ((CustomUser) principal).getUsername();
        }
        return "anonymous";
    }

}
