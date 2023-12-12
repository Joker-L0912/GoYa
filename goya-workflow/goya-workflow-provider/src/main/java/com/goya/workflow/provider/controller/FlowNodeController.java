package com.goya.workflow.provider.controller;

import com.goya.workflow.model.dto.ProcInsDTO;
import com.goya.workflow.model.dto.WorkFlowNode;
import com.goya.workflow.provider.service.FlowNodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ProcInsDTO test(String issueName) {
        return flowNodeService.getNextNodes(issueName);
    }
}
