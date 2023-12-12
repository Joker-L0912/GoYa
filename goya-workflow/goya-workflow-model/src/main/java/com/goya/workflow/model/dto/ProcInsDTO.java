package com.goya.workflow.model.dto;

import lombok.Data;

import java.util.List;

/**
 * @author limoum0u
 * @date 23/12/12 18:01
 */
@Data
public class ProcInsDTO {
    private String procInsId;
    private String currentNodeName;
    private List<WorkFlowNode> nextLnes;
}
