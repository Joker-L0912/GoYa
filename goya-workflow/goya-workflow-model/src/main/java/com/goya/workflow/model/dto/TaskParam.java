package com.goya.workflow.model.dto;

import com.goya.workflow.model.po.WorkFlowNode;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author limoum0u
 * @date 23/12/12 18:01
 */
@Data
public class TaskParam implements Serializable {

    private String issueName;

    private String procInsId;

    private String currentNodeId;

    private String currentNodeName;

    private List<WorkFlowNode> nextLines;

    private WorkFlowNode selectedNode;

    private Map<String, String> submitForm;
}
