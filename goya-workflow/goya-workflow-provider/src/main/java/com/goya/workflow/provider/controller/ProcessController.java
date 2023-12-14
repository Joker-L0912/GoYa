package com.goya.workflow.provider.controller;

import com.goya.workflow.model.dto.ProcInsDTO;
import com.goya.workflow.model.dto.WorkFlowNode;
import com.goya.workflow.provider.repository.IssueInstanceKeyRepository;
import org.apache.commons.lang3.StringUtils;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author limoum0u
 * @date 23/12/12 17:03
 */
@RestController
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    TaskService taskService;

    @Autowired
    RepositoryService repositoryService;

    @Autowired
    IssueInstanceKeyRepository issueInstanceKeyRepository;

    @Autowired
    RuntimeService runtimeService;


    @PostMapping("/complete")
    @Transactional(rollbackFor = Exception.class)
    public int completeTask(@RequestBody ProcInsDTO procInsDTO) {
        String processInsKey;
        if (StringUtils.isEmpty(procInsDTO.getProcInsId())) {
            String issueName = procInsDTO.getIssueName();
            processInsKey = issueInstanceKeyRepository.findProcessInsKeyByIssueName(issueName);
        } else {
            processInsKey = procInsDTO.getProcInsId();
        }
        // 获取当前任务
        Task task = taskService.createTaskQuery().processInstanceId(processInsKey).singleResult();
        WorkFlowNode selectedNode = procInsDTO.getSelectedNode();
        String selectedNodeId = selectedNode.getId();
        Map<String, Object> variables = new HashMap<>(1);
        variables.put("selectId", selectedNodeId);
        runtimeService.setVariable(task.getExecutionId(), "selectId", selectedNodeId);
        taskService.complete(task.getId());
        return 1;
    }

}
