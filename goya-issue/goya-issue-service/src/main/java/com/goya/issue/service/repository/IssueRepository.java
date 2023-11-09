package com.goya.issue.service.repository;

import com.goya.hibernate.repository.BaseRepository;
import com.goya.issue.model.po.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author limoum0u
 * @date 23/10/15 15:47
 */
@Repository
public interface IssueRepository extends BaseRepository<Issue, Long> {
    Optional<Issue> findByName(String name);
}
