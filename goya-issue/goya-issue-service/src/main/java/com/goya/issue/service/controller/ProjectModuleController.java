package com.goya.issue.service.controller;

import com.goya.issue.model.po.ProjectModule;
import com.goya.issue.service.service.ProjectModuleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author limoum0u
 * @date 23/12/8 21:04
 */
@RestController
@RequestMapping("/projectModule")
public class ProjectModuleController {

    private final ProjectModuleService projectModuleService;

    public ProjectModuleController(ProjectModuleService projectModuleService) {
        this.projectModuleService = projectModuleService;
    }

    /**
     * 查询所有的模块
     */
    @RequestMapping("/list")
    public List<ProjectModule> findAll() {
        return projectModuleService.findAll();
    }

}
