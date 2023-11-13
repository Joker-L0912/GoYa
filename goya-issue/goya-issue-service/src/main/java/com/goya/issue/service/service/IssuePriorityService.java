package com.goya.issue.service.service;

import com.goya.issue.model.po.IssuePriority;
import com.goya.issue.service.repository.IssuePriorityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author limoum0u
 * @date 23/11/13 11:25
 */
@Service
public class IssuePriorityService {

    private final IssuePriorityRepository issuePriorityRepository;

    public IssuePriorityService(IssuePriorityRepository issuePriorityRepository) {
        this.issuePriorityRepository = issuePriorityRepository;
    }

    public List<IssuePriority> findAll() {
        return issuePriorityRepository.findAll();
    }
}
