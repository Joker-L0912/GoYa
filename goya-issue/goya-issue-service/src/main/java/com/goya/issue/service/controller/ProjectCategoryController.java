package com.goya.issue.service.controller;

import com.goya.issue.model.po.ProjectCategory;
import com.goya.issue.service.service.ProjectCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author limoum0u
 * @date 23/11/9 17:47
 */
@RestController
@RequestMapping("/projectCategory")
public class ProjectCategoryController {

    private final ProjectCategoryService projectCategoryService;

    public ProjectCategoryController(ProjectCategoryService projectCategoryService) {
        this.projectCategoryService = projectCategoryService;
    }

    @GetMapping("/list")
    public List<ProjectCategory> findAll() {
        return projectCategoryService.findAll();
    }
}
