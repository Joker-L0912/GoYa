package com.goya.issue.service.repository;

import com.goya.hibernate.repository.BaseRepository;
import com.goya.issue.model.po.IssueStatus;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueStatusRepository extends BaseRepository<IssueStatus, Long> {
}