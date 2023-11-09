package com.goya.issue.service.controller;

import com.goya.issue.model.dto.IssueDTO;
import com.goya.issue.model.po.Issue;
import com.goya.issue.service.service.IssueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

//    @GetMapping("/{id}")
//    public Issue getById(@PathVariable Integer id) {
//        Optional<Issue> optionalIssue = issueService.findById(id);
//        return optionalIssue.get();
//    }

    @GetMapping("/{name}")
    public Issue getByName(@PathVariable String name) {
        Optional<Issue> issue = issueService.findByName(name);
        return issue.get();
    }

    @GetMapping
    public List<IssueDTO> findPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "50") Integer pageSize) {
        List<IssueDTO> page = issueService.findPagedList(pageNum, pageSize);
        return page;
    }

    @GetMapping("/count")
    public Long getCount() {
        return issueService.getCount();
    }
}
