package com.goya.issue.service.service;

import com.goya.core.enums.ReturnCode;
import com.goya.core.exception.BaseException;
import com.goya.issue.model.dto.IssueDTO;
import com.goya.issue.model.dto.IssueReqDTO;
import com.goya.issue.model.mapper.IssueMapper;
import com.goya.issue.model.po.*;
import com.goya.issue.service.repository.IssueRepository;
import com.goya.issue.service.repository.ProjectRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author limoum0u
 * @date 23/10/15 15:49
 */
@Service
@Slf4j
public class IssueService {

    private final IssueRepository issueRepository;

    private final ProjectRepository projectRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public IssueService(IssueRepository issueRepository, ProjectRepository projectRepository) {
        this.issueRepository = issueRepository;
        this.projectRepository = projectRepository;
    }

    public Page<Issue> findPage(Integer pageNum, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNum - 1, pageSize);
        Page<Issue> issuePage = issueRepository.findAll(pageRequest);
        return issuePage;
    }

    public Optional<Issue> findByName(String name) {
        return issueRepository.findByName(name);
    }

    public List<IssueDTO> findPagedList(Integer pageNum, Integer pageSize) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<IssueDTO> query = criteriaBuilder.createQuery(IssueDTO.class);

        Root<Issue> i = query.from(Issue.class);
        Join<Issue, IssueType> type = i.join(Issue_.issueType);

        query.select(criteriaBuilder.construct(IssueDTO.class,
                i.get(Issue_.id),
                i.get(Issue_.name).alias("name"),
                i.get(Issue_.gist),
                type.get(IssueType_.name).alias("type"),
                i.get(Issue_.issuePriority),
                i.get(Issue_.issueStatus),
                i.get(Issue_.solutionResult),
                i.get(Issue_.reportedBy),
                i.get(Issue_.handledBy),
                i.get(Issue_.createdAt),
                i.get(Issue_.createdBy)));
        return entityManager.createQuery(query).setFirstResult((pageNum - 1) * pageSize).setMaxResults(pageNum * pageSize).getResultList();
    }

    public Long getCount() {
        return issueRepository.count();
    }

    @Transactional(rollbackFor = Exception.class)
    public String save(IssueReqDTO issueReqDto) {
        Issue issue = IssueMapper.INSTANCE.toEntity(issueReqDto);
        Optional<Project> projectOptional = projectRepository.findById(issueReqDto.getProjectId());
        Project project = projectOptional.orElseThrow(() -> new BaseException(ReturnCode.USER_ERROR_A0400));
        // 生成 issue 的名称 KEY + 数量
        //TODO: 多个线程同时操作这里可能会出现问题
        project.setIssueCount(project.getIssueCount() + 1);
        String issueName = project.getKeyword() + "-" + project.getIssueCount();
        issue.setName(issueName);
        issueRepository.save(issue);
        return issueName;
    }
}
