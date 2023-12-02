package com.goya.workflow;

import com.goya.core.utils.JsonUtils;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.repository.Deployment;
import org.camunda.bpm.engine.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sound.midi.Soundbank;
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
        Deployment deployment = repositoryService.createDeploymentQuery().deploymentId("e7922586-9106-11ee-9dd6-00ff16e5077c").singleResult();
        System.out.println(deployment);
    }

    @Test
    void start(){
        Map<String,Object> paramsMap = new HashMap<>();
        paramsMap.put("pass", "1");
        runtimeService.startProcessInstanceByKey("Process_11yjd0t", "GOYA_BUG_BUSINESSKEY", paramsMap);

    }

    @Test
    void todo(){
        List<Task> todos = taskService.createTaskQuery().taskAssignee("lizihan").list();
        System.out.println(JsonUtils.toJsonString(todos));
    }

    @Test
    void setAssignee(){
        Task task = taskservice.createTaskQuery().processInstanceBusinessKey("GOYA_BUG_BUSINESSKEY").singleResult();
        String id = task.getId();
        taskservice.setAssignee(id, "lizihan");

    }

    @Test
    void complete(){
        taskService.complete("2176f6da-90bc-11ee-8f1f-00ff16e5077c");
    }

}
