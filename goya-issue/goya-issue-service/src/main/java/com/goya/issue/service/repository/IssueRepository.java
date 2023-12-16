package com.goya.issue.service.repository;

import com.goya.hibernate.repository.BaseRepository;
import com.goya.issue.model.po.Issue;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author limoum0u
 * @date 23/10/15 15:47
 */
@Repository
public interface IssueRepository extends BaseRepository<Issue, Long> {
    Optional<Issue> findByNameAndProjectId(String name, Long projectId);

    Long countByProjectId(Long projectId);

    @Query(value = "update Issue set issueStatus = ?2 where name = ?1")
    @Modifying
    int updateIssueStatus(String issueName, String status);
}
