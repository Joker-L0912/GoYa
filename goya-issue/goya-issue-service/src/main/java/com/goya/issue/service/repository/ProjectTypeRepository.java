package com.goya.issue.service.repository;

import com.goya.hibernate.repository.BaseRepository;
import com.goya.issue.model.po.ProjectCategory;
import com.goya.issue.model.po.ProjectType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author limoum0u
 * @date 23/11/9 17:47
 */
@Repository
public interface ProjectTypeRepository extends BaseRepository<ProjectType, Long>{
    /**
     * find all
     *
     * @return List<ProjectType>
     */
    List<ProjectType> findAll();
}
