package com.goya.issue.service.service;

import com.goya.issue.model.dto.IssueDTO;
import com.goya.issue.model.po.Issue;
import com.goya.issue.model.po.IssueType;
import com.goya.issue.model.po.IssueType_;
import com.goya.issue.model.po.Issue_;
import com.goya.issue.service.repository.IssueRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author limoum0u
 * @date 23/10/15 15:49
 */
@Service
public class IssueService {

    private final IssueRepository issueRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public IssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
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
        Join<Issue, IssueType> type = i.join(Issue_.typeId);

        query.select(criteriaBuilder.construct(IssueDTO.class,
                i.get(Issue_.id),
                i.get(Issue_.name).alias("name"),
                i.get(Issue_.gist),
                type.get(IssueType_.name).alias("type"),
                i.get(Issue_.issuePriority),
                i.get(Issue_.issueStatus),
                i.get(Issue_.solutionResultId),
                i.get(Issue_.reportedBy),
                i.get(Issue_.handledBy),
                i.get(Issue_.createdAt),
                i.get(Issue_.createdBy)));
        return entityManager.createQuery(query).setFirstResult((pageNum - 1) * pageSize).setMaxResults(pageNum * pageSize).getResultList();
    }

    public Long getCount() {
        return issueRepository.count();
    }
}
