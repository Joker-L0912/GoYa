package com.goya.auth.provider.controller;

import com.goya.auth.provider.service.UserService;
import com.goya.core.domain.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author limoum0u
 * @date 23/11/6 10:50
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class LoginUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public Result<String> login() {
        return Result.ofSuccess("test");
    }

    @PostMapping("/login")
    public Result<Map<String, String>> login(@RequestBody Map<String, String> loginParam) {
        return userService.login(loginParam);
    }
}
