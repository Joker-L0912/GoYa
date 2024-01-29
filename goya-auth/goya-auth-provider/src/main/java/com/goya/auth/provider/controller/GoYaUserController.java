package com.goya.auth.provider.controller;

import com.goya.auth.model.dto.CustomUser;
import com.goya.auth.provider.service.UserDetailsServiceImpl;
import com.goya.auth.provider.service.UserService;
import com.goya.core.domain.Result;
import com.goya.security.utils.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author limoum0u
 * @date 23/11/6 10:50
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class GoYaUserController {

    private final UserService userService;

    public GoYaUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public Result<String> login() {
        return Result.ofSuccess("test");
    }

    @PostMapping("/login")
    public Result<Map<String, String>> login(@RequestBody Map<String, String> loginParam) {
        return userService.login(loginParam);
    }

    @GetMapping("/info")
    public CustomUser getUserInfo() {
        CustomUser customUser = SecurityUtil.getCustomUser();
        if (customUser == null) {
            throw new RuntimeException("获取用户信息失败");
        }
        return customUser;
    }
}
