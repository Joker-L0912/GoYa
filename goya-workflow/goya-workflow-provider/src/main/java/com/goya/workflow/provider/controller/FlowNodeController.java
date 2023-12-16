package com.goya.workflow.provider.controller;

import com.goya.workflow.model.dto.TaskParam;
import com.goya.workflow.provider.service.FlowNodeService;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author limoum0u
 * @date 23/12/12 16:22
 */
@RestController
@RequestMapping("/flowNode")
public class FlowNodeController {

    private final FlowNodeService flowNodeService;

    public FlowNodeController(FlowNodeService flowNodeService) {
        this.flowNodeService = flowNodeService;
    }

    @GetMapping("/nextline")
    public TaskParam test(String issueName) {
        return flowNodeService.getNextNodes(issueName);
    }
}
