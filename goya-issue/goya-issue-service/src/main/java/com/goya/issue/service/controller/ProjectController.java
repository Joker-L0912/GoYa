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

    /**
     * 获取项目列表
     *
     * @param pageNum  页码
     * @param pageSize 每页数量
     * @return 项目列表
     */
    @GetMapping("/list")
    public Page<Project> list(int pageNum, int pageSize) {
        return projectService.findAll(pageNum, pageSize);
    }


    /**
     * 将请求体中的Project对象保存到数据库中，
     * 并返回保存后的Project对象。
     *
     * @param project 保存的Project对象
     * @return 保存后的Project对象
     */
    @PostMapping
    public Project save(@RequestBody Project project) {
        return projectService.save(project);
    }


    @PutMapping
    /**
     * 更新项目信息
     *
     * @param project 项目信息实体
     * @return 更新后的项目信息实体
     */
    public Project update(@RequestBody Project project) {
        return projectService.update(project);
    }

    /**
     * 根据ID查找项目
     *
     * @param id 项目ID
     * @return 对应的项目对象
     */
    @GetMapping("/{id}")
    public Project findById(@PathVariable Long id) {
        return projectService.findById(id);
    }

    /**
     * 根据ID删除项目
     *
     * @param id 项目ID
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    public int deleteById(@PathVariable Long id) {
        return projectService.deleteById(id);
    }

}
