package com.goya.issue.service.repository;

import com.goya.hibernate.repository.BaseRepository;
import com.goya.issue.model.po.ProjectCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author limoum0u
 * @date 23/11/9 17:47
 */
@Repository
public interface ProjectCategoryRepository extends BaseRepository<ProjectCategory, Long>{
    /**
     * find all
     *
     * @return List<ProjectCategory>
     */
    List<ProjectCategory> findAll();
}
