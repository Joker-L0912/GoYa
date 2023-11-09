package com.goya.issue.service.controller;

import com.goya.issue.model.po.ProjectType;
import com.goya.issue.service.service.ProjectTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author limoum0u
 * @date 23/11/9 17:47
 */
@RestController
@RequestMapping("/projectType")
public class ProjectTypeController {

    private final ProjectTypeService projectTypeService;

    public ProjectTypeController(ProjectTypeService projectTypeService) {
        this.projectTypeService = projectTypeService;
    }

    @GetMapping("/list")
    public List<ProjectType> findAll() {
        return projectTypeService.findAll();
    }
}
