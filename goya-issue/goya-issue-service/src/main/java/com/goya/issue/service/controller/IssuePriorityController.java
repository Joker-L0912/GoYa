package com.goya.issue.service.controller;

import com.goya.issue.model.po.IssuePriority;
import com.goya.issue.service.service.IssuePriorityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author limoum0u
 * @date 23/11/13 11:25
 */
@RestController
@RequestMapping("/priority")
public class IssuePriorityController {

    private final IssuePriorityService issuePriorityService;

    public IssuePriorityController(IssuePriorityService issuePriorityService) {
        this.issuePriorityService = issuePriorityService;
    }

    /**
     * 查询所有的优先级
     *
     * @return 优先级列表
     */
    @RequestMapping("/list")
    public List<IssuePriority> findAll() {
        return issuePriorityService.findAll();
    }
}
