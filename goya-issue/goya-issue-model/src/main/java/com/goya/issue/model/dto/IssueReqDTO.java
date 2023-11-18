package com.goya.issue.model.dto;

import com.goya.issue.model.po.Issue;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Issue}
 */
@Data
public class IssueReqDTO implements Serializable {
    String gist;
    Long issueTypeId;
    Long projectId;
    String description;
    String issuePriority;
    String issueStatus;
    String solutionResult;
    Long affectedVersionId;
    Long fixVersionId;
    Long projectModuleId;
    Long epicLinkId;
    String epicLinkName;
    String reportedBy;
    String handledBy;
    String developedBy;
    String testedBy;
}