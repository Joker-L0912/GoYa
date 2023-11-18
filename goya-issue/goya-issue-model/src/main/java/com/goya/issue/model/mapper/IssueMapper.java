package com.goya.issue.model.mapper;

import com.goya.issue.model.dto.IssueReqDTO;
import com.goya.issue.model.po.Issue;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * @author limoum0u
 * @date 23/11/16 23:26
 */

@Mapper
public interface IssueMapper {

    IssueMapper INSTANCE = Mappers.getMapper(IssueMapper.class);

    @Mapping(source = "projectModuleId", target = "projectModule.id")
    @Mapping(source = "fixVersionId", target = "fixVersion.id")
    @Mapping(source = "affectedVersionId", target = "affectedVersion.id")
    @Mapping(source = "projectId", target = "project.id")
    @Mapping(source = "issueTypeId", target = "issueType.id")
    Issue toEntity(IssueReqDTO issueReqDTO);

    @InheritInverseConfiguration(name = "toEntity")
    IssueReqDTO toDto(Issue issue);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Issue partialUpdate(IssueReqDTO issueReqDTO, @MappingTarget Issue issue);
}
