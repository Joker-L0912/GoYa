package com.goya.workflow.provider.service;

import com.goya.workflow.api.RemoteWorkflowService;
import com.goya.workflow.model.dto.TaskParam;
import com.goya.workflow.model.po.IssueInstanceKey;
import com.goya.workflow.model.po.WorkFlowNode;
import com.goya.workflow.provider.repository.CategoryDefinitionRepository;
import com.goya.workflow.provider.repository.IssueInstanceKeyRepository;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author limoum0u
 * @date 23/12/10 22:02
 */
@DubboService
@Service
@Setter
public class RemoteWorkflowServiceImpl implements RemoteWorkflowService {

    private RuntimeService runtimeService;

    private CategoryDefinitionRepository categoryDefinitionRepository;

    private IssueInstanceKeyRepository issueInstanceKeyRepository;

    public TaskService taskService;

    /**
     * 部署流程
     *
     * @param variables
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void startProcess(Map<String, String> variables) {
        String issueTypeId = variables.get("issueTypeId");
        String issueName = variables.get("issueName");
        long l = Long.parseLong(issueTypeId);
        Map<String, Object> params = new HashMap<>();
        params.put("issue", variables);
        params.put("selectId", "start");
        String processDefKey = categoryDefinitionRepository.findProcessDefinitionKeyByCategoryKey(l);

        // 启动流程
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefKey, params);
        String processInstanceId = processInstance.getProcessInstanceId();

        // 保存问题和流程实例
        IssueInstanceKey issueInstanceKey = new IssueInstanceKey();
        issueInstanceKey.setIssueName(issueName);
        issueInstanceKey.setProcessInstanceKey(processInstanceId);
        issueInstanceKeyRepository.save(issueInstanceKey);
    }

    @Override
    public void completeTask(TaskParam taskParam) {
        String processInsKey;
        if (StringUtils.isEmpty(taskParam.getProcInsId())) {
            String issueName = taskParam.getIssueName();
            processInsKey = issueInstanceKeyRepository.findProcessInsKeyByIssueName(issueName);
        } else {
            processInsKey = taskParam.getProcInsId();
        }
        // 获取当前任务
        Task task = taskService.createTaskQuery().processInstanceId(processInsKey).singleResult();
        WorkFlowNode selectedNode = taskParam.getSelectedNode();
        String selectedNodeId = selectedNode.getId();
        runtimeService.setVariable(task.getExecutionId(), "selectId", selectedNodeId);
        taskService.complete(task.getId());
    }

    @Autowired
    public void setRuntimeService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @Autowired
    public void setCategoryDefinitionRepository(CategoryDefinitionRepository categoryDefinitionRepository) {
        this.categoryDefinitionRepository = categoryDefinitionRepository;
    }

    @Autowired
    public void setIssueInstanceKeyRepository(IssueInstanceKeyRepository issueInstanceKeyRepository) {
        this.issueInstanceKeyRepository = issueInstanceKeyRepository;
    }

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
}
