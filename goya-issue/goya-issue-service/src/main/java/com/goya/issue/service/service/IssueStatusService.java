package com.goya.issue.service.service;

import com.goya.issue.model.po.IssueStatus;
import com.goya.issue.service.repository.IssueStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author limoum0u
 * @date 23/11/13 12:41
 */
@Service
public class IssueStatusService {
    private final IssueStatusRepository issueStatusRepository;

    public IssueStatusService(IssueStatusRepository issueStatusRepository) {
        this.issueStatusRepository = issueStatusRepository;
    }

    public List<IssueStatus> findAll() {
        return issueStatusRepository.findAll();
    }
}
