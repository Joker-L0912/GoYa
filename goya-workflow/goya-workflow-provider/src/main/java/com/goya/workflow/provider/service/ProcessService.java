package com.goya.workflow.provider.service;

import com.goya.workflow.model.dto.TaskParam;
import com.goya.workflow.model.po.WorkFlowNode;
import com.goya.workflow.provider.repository.IssueInstanceKeyRepository;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author limoum0u
 * @date 23/12/15 22:39
 */
@Service
@Setter(onMethod_ = {@Autowired})
public class ProcessService {

    TaskService taskService;

    IssueInstanceKeyRepository issueInstanceKeyRepository;

    RuntimeService runtimeService;

    public void completeTask(TaskParam taskParam) {

    }
}
