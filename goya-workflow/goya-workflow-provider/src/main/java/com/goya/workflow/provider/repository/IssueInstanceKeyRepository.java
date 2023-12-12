package com.goya.workflow.provider.repository;

import com.goya.hibernate.repository.BaseRepository;
import com.goya.workflow.model.po.IssueInstanceKey;
import org.springframework.data.jpa.repository.Query;

public interface IssueInstanceKeyRepository extends BaseRepository<IssueInstanceKey, Long> {
    @Query("select i.processInstanceKey from IssueInstanceKey i where i.issueName = ?1")
    String findProcessInsKeyByIssueName(String issueName);
}