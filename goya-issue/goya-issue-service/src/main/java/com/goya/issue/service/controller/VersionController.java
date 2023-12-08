package com.goya.issue.service.controller;

import com.goya.issue.model.po.Version;
import com.goya.issue.service.service.VersionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author limoum0u
 * @date 23/12/7 23:23
 */
@RestController
@RequestMapping("/version")
public class VersionController {

    private final VersionService versionService;

    public VersionController(VersionService versionService) {
        this.versionService = versionService;
    }

    /**
     * 查询所有的版本
     */
    @RequestMapping("/list")
    public List<Version> findAll() {
        return versionService.findAll();
    }
}
