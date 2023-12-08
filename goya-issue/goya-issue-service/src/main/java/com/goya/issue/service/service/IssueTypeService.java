package com.goya.issue.service.service;

import com.goya.issue.model.po.IssueType;
import com.goya.issue.service.repository.IssueTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author limoum0u
 * @date 23/12/7 22:46
 */
@Service
@RequiredArgsConstructor
public class IssueTypeService {

    private final IssueTypeRepository issueTypeRepository;

    /**
     * 查询所有的问题类型
     */
    public List<IssueType> findAll() {
        return issueTypeRepository.findAll();
    }

}
