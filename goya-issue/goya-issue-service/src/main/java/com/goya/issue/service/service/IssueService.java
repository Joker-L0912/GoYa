package com.goya.issue.service.service;

import com.goya.core.enums.ReturnCode;
import com.goya.core.exception.BaseException;
import com.goya.issue.model.dto.IssueListItemDTO;
import com.goya.issue.model.dto.IssueReqDTO;
import com.goya.issue.model.mapper.IssueMapper;
import com.goya.issue.model.po.*;
import com.goya.issue.service.repository.IssueRepository;
import com.goya.issue.service.repository.ProjectRepository;
import com.goya.workflow.api.RemoteWorkflowService;
import com.goya.workflow.model.dto.TaskParam;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
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

    @DubboReference(timeout = 20000, retries = 0)
    private RemoteWorkflowService remoteWorkflowService;

    @PersistenceContext
    private EntityManager entityManager;

    public IssueService(IssueRepository issueRepository, ProjectRepository projectRepository) {
        this.issueRepository = issueRepository;
        this.projectRepository = projectRepository;
    }

    public Page<Issue> findPage(Integer pageNum, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNum - 1, pageSize);
        return issueRepository.findAll(pageRequest);
    }

    public Optional<Issue> findByName(String name, Long projectId) {
        return issueRepository.findByNameAndProjectId(name, projectId);
    }

    public List<IssueListItemDTO> findPagedList(Integer pageNum, Integer pageSize, Long projectId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<IssueListItemDTO> query = criteriaBuilder.createQuery(IssueListItemDTO.class);

        Root<Issue> i = query.from(Issue.class);
        Join<Issue, IssueType> type = i.join(Issue_.issueType);
        Join<Issue, Project> projectJoin = i.join(Issue_.project);

        query.select(criteriaBuilder.construct(IssueListItemDTO.class, i.get(Issue_.id), i.get(Issue_.name).alias(
                        "name"), i.get(Issue_.gist), type.get(IssueType_.name).alias("type"),
                i.get(Issue_.issuePriority),
                i.get(Issue_.issueStatus), projectJoin.get(Project_.name).alias("projectName"),
                i.get(Issue_.solutionResult), i.get(Issue_.reportedBy), i.get(Issue_.handledBy),
                i.get(Issue_.createdAt), i.get(Issue_.createdBy)));
        query.where(criteriaBuilder.equal(i.get(Issue_.project).get(Project_.id), projectId));
        return entityManager.createQuery(query).setFirstResult((pageNum - 1) * pageSize).setMaxResults(pageNum * pageSize).getResultList();
    }

    public Long getCount(Long projectId) {
        return issueRepository.countByProjectId(projectId);
    }

    @Transactional(rollbackFor = Exception.class)
    public String save(Map<String, String> issueMap) {
        IssueReqDTO issueReqDto = IssueMapper.INSTANCE.map2Dto(issueMap);
        Optional<Project> projectOptional = projectRepository.findById(issueReqDto.getProjectId());
        Project project = projectOptional.orElseThrow(() -> new BaseException(ReturnCode.USER_ERROR_A0400));
        // 生成 issue 的名称 KEY + 数量
        //TODO: 多个线程同时操作这里可能会出现问题
        int issueCount = project.getIssueCount();
        project.setIssueCount(issueCount + 1);
        projectRepository.save(project);

        String issueName = project.getKeyword() + "-" + issueCount;
        Issue issue = IssueMapper.INSTANCE.toEntity(issueReqDto);
        issue.setName(issueName);
        issueMap.put("issueName", issueName);
        issueRepository.save(issue);
        // 流程
        remoteWorkflowService.startProcess(issueMap);
        return issueName;
    }

    public int completeTask(TaskParam taskParam) {
        remoteWorkflowService.completeTask(taskParam);
        return 1;
    }

}
