package com.goya.auth.provider.controller;

import com.goya.auth.model.po.GoYaMenu;
import com.goya.auth.provider.service.GoYaMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author limoum0u
 * @date 23/12/26 10:52
 */
@RestController
@RequestMapping("/menu")
public class GoYaMenuController {

    private GoYaMenuService menuService;

    @GetMapping("/list")
    public List<GoYaMenu> findAll() {
        return menuService.findAll();
    }

    @Autowired
    public void setMenuService(GoYaMenuService menuService) {
        this.menuService = menuService;
    }
}
