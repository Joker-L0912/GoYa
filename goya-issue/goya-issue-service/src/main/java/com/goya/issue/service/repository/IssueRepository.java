package com.goya.issue.service.repository;

import com.goya.hibernate.repository.BaseRepository;
import com.goya.issue.model.dto.IssueListItemDTO;
import com.goya.issue.model.po.Issue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Query("""
            select new com.goya.issue.model.dto.IssueListItemDTO(
                i.id,
                i.name,
                i.gist,
                it.name,
                i.issuePriority,
                i.issueStatus,
                p.name,
                i.solutionResult,
                i.reportedBy,
                i.handledBy,
                i.createdAt,
                i.createdBy
            ) from Issue i
            left join Project p on i.project.id = p.id
            left join IssueType it on i.issueType.id = it.id
            where i.handledBy = :username
            and i.solutionResult is null
            and p.id = :projectId
            """)
    Page<IssueListItemDTO> findByHandledByAndSolutionResultNull(Long projectId, String username, Pageable pageable);


}
