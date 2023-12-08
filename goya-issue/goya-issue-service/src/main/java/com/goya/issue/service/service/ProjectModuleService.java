package com.goya.issue.service.service;

import com.goya.issue.model.po.ProjectModule;
import com.goya.issue.service.repository.ProjectModuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author limoum0u
 * @date 23/12/8 21:03
 */
@Service
public class ProjectModuleService {

    private final ProjectModuleRepository projectModuleRepository;

    public ProjectModuleService(ProjectModuleRepository projectModuleRepository) {
        this.projectModuleRepository = projectModuleRepository;
    }

    /**
     * 查询所有的模块
     */
    public List<ProjectModule> findAll() {
        return projectModuleRepository.findAll();
    }
}
