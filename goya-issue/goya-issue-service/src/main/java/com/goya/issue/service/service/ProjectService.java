package com.goya.issue.service.service;

import com.goya.issue.model.po.Project;
import com.goya.issue.service.repository.ProjectRepository;
import com.goya.security.utils.SecurityUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author limoum0u
 * @date 23/11/9 17:16
 */
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Page<Project> findAll(int pageNum, int pageSize) {
        String username = SecurityUtil.getUsername();
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        Pageable pageable = Pageable.ofSize(pageSize).withPage(pageNum);
        return projectRepository.findByUsers_Username(username, pageable);
    }

    @Transactional
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Transactional
    public Project update(Project project) {
        return projectRepository.save(project);
    }

    public Project findById(Long id) {
        String username = SecurityUtil.getUsername();
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        return projectRepository.findByIdAndUsers_Username(id, username).orElse(null);
    }

    @Transactional
    public int deleteById(Long id) {
        projectRepository.deleteById(id);
        return 1;
    }
}
