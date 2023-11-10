package com.goya.issue.service.controller;

import com.goya.issue.model.po.Project;
import com.goya.issue.service.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author limoum0u
 * @date 23/11/9 17:16
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/list")
    public Page<Project> list(int pageNum, int pageSize) {
        return projectService.findAll(pageNum, pageSize);
    }

    @PostMapping
    public Project save(@RequestBody Project project) {
        return projectService.save(project);
    }

    @PutMapping
    public Project update(@RequestBody Project project) {
        return projectService.update(project);
    }

}
