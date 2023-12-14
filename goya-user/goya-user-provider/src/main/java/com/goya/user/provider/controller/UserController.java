package com.goya.user.provider.controller;

import com.goya.user.model.dto.GoYaUserDTO;
import com.goya.user.provider.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author limoum0u
 * @date 23/11/20 16:29
 */
@RestController
@RequestMapping("/info")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<GoYaUserDTO> getUserInfoPart(String username) {
        return userService.getUserInfoPart(username);
    }

}
