package com.goya.issue.service.service;

import com.goya.issue.model.po.ProjectCategory;
import com.goya.issue.service.repository.ProjectCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author limoum0u
 * @date 23/11/9 17:47
 */
@Service
public class ProjectCategoryService {

    private final ProjectCategoryRepository projectCategoryRepository;

    public ProjectCategoryService(ProjectCategoryRepository projectCategoryRepository) {
        this.projectCategoryRepository = projectCategoryRepository;
    }

    public List<ProjectCategory> findAll() {
        return projectCategoryRepository.findAll();
    }
}
