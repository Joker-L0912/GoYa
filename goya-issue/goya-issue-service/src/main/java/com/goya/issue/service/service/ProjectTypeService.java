package com.goya.issue.service.service;

import com.goya.issue.model.po.ProjectCategory;
import com.goya.issue.model.po.ProjectType;
import com.goya.issue.service.repository.ProjectCategoryRepository;
import com.goya.issue.service.repository.ProjectTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author limoum0u
 * @date 23/11/9 17:47
 */
@Service
public class ProjectTypeService {

    private final ProjectTypeRepository projectCategoryRepository;

    public ProjectTypeService(ProjectTypeRepository projectCategoryRepository) {
        this.projectCategoryRepository = projectCategoryRepository;
    }

    public List<ProjectType> findAll() {
        return projectCategoryRepository.findAll();
    }
}
