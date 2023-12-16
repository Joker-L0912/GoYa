package com.goya.workflow.provider.repository;

import com.goya.hibernate.repository.BaseRepository;
import com.goya.workflow.model.po.IssueInstanceKey;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IssueInstanceKeyRepository extends BaseRepository<IssueInstanceKey, Long> {
    @Query("select i.processInstanceKey from IssueInstanceKey i where i.issueName = ?1")
    String findProcessInsKeyByIssueName(String issueName);

    Optional<IssueInstanceKey> findByProcessInstanceKey(String processInstanceKey);

    @Modifying
    @Transactional
    @Query("update IssueInstanceKey i set i.issueStatus = :issueStatus where i.issueName = :issueName")
    void updateStatusByIssueName(String issueName, String issueStatus);


}