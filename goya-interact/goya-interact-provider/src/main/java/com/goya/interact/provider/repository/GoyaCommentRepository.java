package com.goya.interact.provider.repository;

import com.goya.hibernate.repository.BaseRepository;
import com.goya.interact.model.po.GoyaComment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoyaCommentRepository extends BaseRepository<GoyaComment, String> {
    List<GoyaComment> findByIssueName(String issueName);


}