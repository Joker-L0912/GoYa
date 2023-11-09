package com.goya.auth.provider.controller;

import com.goya.core.domain.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author limoum0u
 * @date 23/11/6 10:50
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class LoginUserController {

    @GetMapping("/test")
    public Result<String> login() {
        return Result.ofSuccess("test");
    }
}
