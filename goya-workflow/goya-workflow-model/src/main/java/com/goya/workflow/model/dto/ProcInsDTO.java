package com.goya.workflow.model.dto;

import lombok.Data;

import java.util.List;

/**
 * @author limoum0u
 * @date 23/12/12 18:01
 */
@Data
public class ProcInsDTO {

    private String issueName;
    private String procInsId;

    private String currentNodeId;
    private String currentNodeName;

    private List<WorkFlowNode> nextLines;

    private WorkFlowNode selectedNode;
}
