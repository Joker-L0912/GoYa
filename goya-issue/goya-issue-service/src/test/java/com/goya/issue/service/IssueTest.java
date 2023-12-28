package com.goya.issue.service;

import com.goya.core.utils.JsonUtils;
import com.goya.issue.model.dto.IssueListItemDTO;
import com.goya.issue.model.po.Project;
import com.goya.issue.service.repository.IssueRepository;
import com.goya.issue.service.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author limoum0u
 * @date 23/12/11 12:58
 */
@SpringBootTest
@Slf4j
public class IssueTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private IssueRepository issueRepository;
//    @Test
//    @Transactional
//    public void test1() {
//        Pageable pageable = Pageable.ofSize(2).withPage(0);
//
//        Page<Project> projects = projectRepository.findByUsers_Username("lizihan", pageable);
//        log.info(JsonUtils.toJsonString(projects));
//    }

    @Test
    @Transactional
    public void test1() {
        Pageable pageable = Pageable.ofSize(2).withPage(0);

        Page<IssueListItemDTO> issueListItemDTOS = issueRepository.findByHandledByAndSolutionResultNull(1L, "lizihan",
                pageable);
        log.info(issueListItemDTOS.toString());
    }
}
