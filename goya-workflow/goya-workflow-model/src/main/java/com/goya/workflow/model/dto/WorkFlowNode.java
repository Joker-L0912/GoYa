package com.goya.workflow.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author limoum0u
 * @date 23/12/12 17:54
 */
@Data
@AllArgsConstructor
public class WorkFlowNode {
    private String id;
    private String name;
    private String type;
}
