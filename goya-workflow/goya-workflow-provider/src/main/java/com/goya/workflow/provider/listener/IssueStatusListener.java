package com.goya.workflow.provider.listener;

import com.goya.issue.api.RemoteIssueService;
import com.goya.workflow.provider.repository.IssueInstanceKeyRepository;
import org.apache.dubbo.config.annotation.DubboReference;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author limoum0u
 * @date 23/12/15 14:28
 */
@Service
public class IssueStatusListener implements TaskListener {

    private IssueInstanceKeyRepository issueInstanceKeyRepository;

    @DubboReference(timeout = 20000, retries = 0, async = true)
    private RemoteIssueService issueService;

    @Override
    public void notify(DelegateTask delegateTask) {
        // 获取当前节点的名称
        String name = delegateTask.getName();
        String processInstanceId = delegateTask.getProcessInstanceId();
        // 修改状态
        issueInstanceKeyRepository.findByProcessInstanceKey(processInstanceId)
                .ifPresent(issueInstance -> issueInstance.setIssueStatus(name));
        //问题服务更改问题状态
        Object issue = delegateTask.getVariable("issue");
        if (issue instanceof Map) {
            Map<String, String> issueMap = (Map<String, String>) issue;
            String issueName = issueMap.get("issueName");
            issueService.updateIssueStatus(issueName, name);
        }
        //更新流程服务 中的问题状态
        issueInstanceKeyRepository.findByProcessInstanceKey(processInstanceId)
                .ifPresent(issueInstance -> issueInstance.setIssueStatus(name));

    }

    @Autowired
    public void setIssueInstanceKeyRepository(IssueInstanceKeyRepository issueInstanceKeyRepository) {
        this.issueInstanceKeyRepository = issueInstanceKeyRepository;
    }
}
