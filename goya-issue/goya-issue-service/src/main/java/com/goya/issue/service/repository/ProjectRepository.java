package com.goya.issue.service.repository;

import com.goya.hibernate.repository.BaseRepository;
import com.goya.issue.model.po.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * @author limoum0u
 * @date 23/11/9 17:16
 */
@Repository
public interface ProjectRepository extends BaseRepository<Project, Long> {

    Page<Project> findAll(Pageable pageable);
}
