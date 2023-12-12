package com.goya.issue.service.controller;

import com.goya.issue.model.dto.IssueListItemDTO;
import com.goya.issue.model.dto.IssueReqDTO;
import com.goya.issue.model.po.Issue;
import com.goya.issue.service.service.IssueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * 问题主表 前端控制器
 * </p>
 *
 * @author lizihan
 * @since 2023-10-06 04:28:42
 */
@RestController
@RequestMapping("/issue")
public class IssueController {

    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @GetMapping("/{name}")
    public Issue getByName(@PathVariable String name, @RequestParam Long projectId) {
        Optional<Issue> issue = issueService.findByName(name, projectId);
        return issue.get();
    }

    @GetMapping
    public List<IssueListItemDTO> findPage(Long projectId,
                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                           @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {
        return issueService.findPagedList(pageNum, pageSize, projectId);
    }

    @GetMapping("/count")
    public Long getCount(@RequestParam Long projectId) {
        return issueService.getCount(projectId);
    }

    /**
     * 新增
     *
     * @return issueName
     */
    @PostMapping
    public String addIssue(@RequestBody Map<String, String> issueMap) {
        return issueService.save(issueMap);
    }

}
