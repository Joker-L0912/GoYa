package com.goya.issue.service.service;

import com.goya.issue.api.RemoteIssueService;
import com.goya.issue.service.repository.IssueRepository;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author limoum0u
 * @date 23/12/15 23:11
 */
@DubboService
@Service
public class RemoteIssueServiceImpl implements RemoteIssueService {

    IssueRepository issueRepository;

    @Override
    @Transactional
    public int updateIssueStatus(String issueName, String status) {
        return issueRepository.updateIssueStatus(issueName, status);
    }

    @Autowired
    public void setIssueRepository(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }
}
