package com.goya.workflow.provider.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Service;

/**
 * @author limoum0u
 * @date 23/12/11 17:11
 */
@Service
public class ConditionalFlowDirectionJudgment {

    public boolean execute(DelegateExecution execution) {
        return false;
    }

    ;
}
