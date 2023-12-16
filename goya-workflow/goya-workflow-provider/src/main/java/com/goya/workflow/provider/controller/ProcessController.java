package com.goya.workflow.provider.controller;

import com.goya.workflow.model.dto.TaskParam;
import com.goya.workflow.provider.repository.IssueInstanceKeyRepository;
import com.goya.workflow.provider.service.ProcessService;
import lombok.Setter;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author limoum0u
 * @date 23/12/12 17:03
 */
@RestController
@RequestMapping("/process")
@Setter(onMethod_ = {@Autowired})
public class ProcessController {

    TaskService taskService;

    RepositoryService repositoryService;

    IssueInstanceKeyRepository issueInstanceKeyRepository;

    RuntimeService runtimeService;

    ProcessService processService;

    @PostMapping("/complete")
    @Transactional(rollbackFor = Exception.class)
    public int completeTask(@RequestBody TaskParam taskParam) {
        processService.completeTask(taskParam);
        return 1;
    }

}
