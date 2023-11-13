package com.goya.issue.service.controller;

import com.goya.issue.model.po.IssueStatus;
import com.goya.issue.service.service.IssueStatusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author limoum0u
 * @date 23/11/13 12:42
 */
@RestController
@RequestMapping("/issueStatus")
public class IssueStatusController {
    private final IssueStatusService issueStatusService;

    public IssueStatusController(IssueStatusService issueStatusService) {
        this.issueStatusService = issueStatusService;
    }

    @GetMapping("list")
    public List<IssueStatus> findAll() {
        return issueStatusService.findAll();
    }
}
