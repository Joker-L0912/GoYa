package com.goya.issue.model.dto;

import com.goya.issue.model.po.Project;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Project}
 */
@Value
public class ProjectDto implements Serializable {
    Long id;
    String name;
    String icon;
    String keyword;
    String description;
    Long categoryId;
    Long typeId;
    String manager;
    String status;
    Integer issueCount;
}