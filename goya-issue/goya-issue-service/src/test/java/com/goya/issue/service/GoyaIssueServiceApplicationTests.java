package com.goya.issue.service;

import com.goya.issue.model.dto.IssueDTO;
import com.goya.issue.model.po.Issue;
import com.goya.issue.model.po.IssueType;
import com.goya.issue.model.po.IssueType_;
import com.goya.issue.model.po.Issue_;
import com.goya.issue.service.repository.IssueRepository;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
class GoyaIssueServiceApplicationTests {

    @Resource
    private IssueRepository issueRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testJoin() {
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

        List<IssueDTO> resultList = entityManager.createQuery(query).setFirstResult(0).setMaxResults(10).getResultList();
        System.out.println(resultList);
    }

}
