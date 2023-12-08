package com.goya.workflow.provider;

import com.goya.core.utils.JsonUtils;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.repository.Deployment;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.bpmn.instance.FlowNode;
import org.camunda.bpm.model.bpmn.instance.SequenceFlow;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class GoyaWorkflowApplicationTests {

    @Autowired
    RepositoryService repositoryService;

    @Autowired
    TaskService taskService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private TaskService taskservice;

    @Test
    void deployment() {
        Deployment deployment = repositoryService.createDeploymentQuery().deploymentId("e7922586-9106-11ee-9dd6" +
                "-00ff16e5077c").singleResult();
        System.out.println(deployment);
    }

    @Test
    void start() {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("pass", "1");
        runtimeService.startProcessInstanceByKey("Process_11yjd0t", "GOYA_BUG_BUSINESSKEY", paramsMap);

    }

    @Test
    void todo() {
        List<Task> todos = taskService.createTaskQuery().taskAssignee("lizihan").list();
        System.out.println(JsonUtils.toJsonString(todos));
    }

    @Test
    void setAssignee() {
        Task task = taskservice.createTaskQuery().processInstanceBusinessKey("GOYA_BUG_BUSINESSKEY").singleResult();
        String id = task.getId();
        taskservice.setAssignee(id, "lizihan");

    }

    @Test
    void complete() {
        taskService.complete("2176f6da-90bc-11ee-8f1f-00ff16e5077c");
    }

    @Test
    void getActivitiList() {
        String definitionId = runtimeService.createProcessInstanceQuery()
                .processInstanceId("c3f2fd31-91df-11ee-958e-00ff16e5077c")
                .singleResult()
                .getProcessDefinitionId();
        BpmnModelInstance bpmnModelInstance = repositoryService.getBpmnModelInstance(definitionId);
        for (FlowNode flowNode : bpmnModelInstance.getModelElementsByType(FlowNode.class)) {
            System.out.println("Node Id: " + flowNode.getId());
            System.out.println("Node Name: " + flowNode.getName());
            System.out.println("Node Type: " + flowNode.getElementType().getTypeName());
            Collection<SequenceFlow> outgoing = flowNode.getOutgoing();
            for (SequenceFlow sequenceFlow : outgoing) {
                System.out.println("SequenceFlow: " + sequenceFlow.getName());
            }
            System.out.println("---");
        }

    }

    @Test
    void getNext() {
        Execution execution = runtimeService.createExecutionQuery().processInstanceId("c3f2fd31-91df-11ee-958e-00ff16e5077c").singleResult();
        Task currentTask = taskService.createTaskQuery().executionId(execution.getId()).singleResult();
        String processInstanceId = currentTask.getProcessInstanceId();
        String s = runtimeService.getActiveActivityIds(processInstanceId).get(0);

        String definitionId = runtimeService.createProcessInstanceQuery()
                .processInstanceId("c3f2fd31-91df-11ee-958e-00ff16e5077c")
                .singleResult()
                .getProcessDefinitionId();
        BpmnModelInstance bpmnModelInstance = repositoryService.getBpmnModelInstance(definitionId);
        FlowNode currentNode = bpmnModelInstance.getModelElementById(s);
        List<FlowNode> list = currentNode.getSucceedingNodes().list();
        System.out.println(list);

    }
}
