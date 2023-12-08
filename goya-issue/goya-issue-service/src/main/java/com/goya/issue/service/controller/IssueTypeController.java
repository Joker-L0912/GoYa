package com.goya.issue.service.controller;

import com.goya.issue.service.service.IssueTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author limoum0u
 * @date 23/12/7 22:45
 */
@RestController
@RequestMapping("/type")
public class IssueTypeController {

    private final IssueTypeService issueTypeService;

    public IssueTypeController(IssueTypeService issueTypeService) {
        this.issueTypeService = issueTypeService;
    }

    /**
     * 查询所有的问题类型
     */
    @GetMapping("/list")
    public Object findAll() {
        return issueTypeService.findAll();
    }
}
