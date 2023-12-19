package com.goya.workflow.api;



import com.goya.workflow.model.dto.TaskParam;

import java.util.Map;

/**
 * @author limoum0u
 * @date 23/12/10 21:57
 */
public interface RemoteWorkflowService {
    /**
     * 部署流程
     */
    void startProcess(Map<String, String> variables);

    void completeTask(TaskParam taskParam);
}
