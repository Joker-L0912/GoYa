package com.goya.issue.service.service;

import com.goya.issue.model.po.Version;
import com.goya.issue.service.repository.VersionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author limoum0u
 * @date 23/12/7 23:23
 */
@Service
public class VersionService {

    private final VersionRepository versionRepository;

    public VersionService(VersionRepository versionRepository) {
        this.versionRepository = versionRepository;
    }

    /**
     * 查询所有的版本
     */
    public List<Version> findAll() {
        return versionRepository.findAll();
    }
}
