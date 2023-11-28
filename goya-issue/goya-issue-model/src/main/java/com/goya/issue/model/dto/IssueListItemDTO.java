package com.goya.issue.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author limoum0u
 * @date 23/10/15 15:36
 */

@Data
@AllArgsConstructor
public class IssueListItemDTO {
    private Long id;

    private String name;
    /**
     * 摘要
     */
    private String gist;

    /**
     * 类型
     */
    private String type;

    /**
     * 优先级
     */
    private String issuePriority;
//    private Integer priorityId;
    /**
     * 状态
     */
    private String issueStatus;
    /**
     * 项目
     */
    private String projectName;
    /**
     * 解决结果
     */

    private String solutionResult;

    /**
     * 报告人
     */
    private String reportedBy;

    /**
     * 经办人
     */
    private String handledBy;
    /**
     * created_at
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date createdAt;

    /**
     * created_by
     */
    private String createdBy;

}
