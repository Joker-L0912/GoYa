package com.goya.workflow.provider.service;

import com.goya.workflow.model.dto.ProcInsDTO;
import com.goya.workflow.model.dto.WorkFlowNode;
import com.goya.workflow.provider.repository.IssueInstanceKeyRepository;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.bpmn.instance.FlowNode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author limoum0u
 * @date 23/12/12 16:28
 */
@Service
public class FlowNodeService {

    private final RuntimeService runtimeService;

    private final TaskService taskService;

    private final RepositoryService repositoryService;

    private final IssueInstanceKeyRepository issueInstanceKeyRepository;

    public FlowNodeService(RuntimeService runtimeService, TaskService taskService,
                           RepositoryService repositoryService, IssueInstanceKeyRepository issueInstanceKeyRepository) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
        this.repositoryService = repositoryService;
        this.issueInstanceKeyRepository = issueInstanceKeyRepository;
    }

    public ProcInsDTO getNextNodes(String issueName) {
        String processInstanceId = issueInstanceKeyRepository.findProcessInsKeyByIssueName(issueName);
        Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
        String definitionId = task.getProcessDefinitionId();
        BpmnModelInstance bpmnModel = repositoryService.getBpmnModelInstance(definitionId);
        FlowNode currentNode = bpmnModel.getModelElementById(task.getTaskDefinitionKey());
        List<WorkFlowNode> list = new ArrayList<>();
        currentNode.getOutgoing().forEach(sequenceFlow -> {
            Map<String, String> map = new HashMap<>();
            String name = sequenceFlow.getName();
            String id = sequenceFlow.getId();
            WorkFlowNode workFlowNode = new WorkFlowNode(id, name, "sequenceFlow");
            list.add(workFlowNode);
        });
        ProcInsDTO procInsDTO = new ProcInsDTO();
        procInsDTO.setProcInsId(processInstanceId);
        procInsDTO.setCurrentNodeName(currentNode.getName());
        procInsDTO.setNextLines(list);
        return procInsDTO;
    }
}
