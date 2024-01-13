package com.goya.interact.provider.service;

import com.goya.interact.model.po.GoyaComment;
import com.goya.interact.provider.repository.GoyaCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author limoum0u
 * @date 23/12/29 17:43
 */
@Service
public class GoyaCommentService {

    private GoyaCommentRepository goyaCommentRepository;

    @Autowired
    public void setGoyaCommentRepository(GoyaCommentRepository goyaCommentRepository) {
        this.goyaCommentRepository = goyaCommentRepository;
    }

    public List<GoyaComment> getComment(String issueName) {
        List<GoyaComment> commentList = goyaCommentRepository.findByIssueName(issueName);
        return commentList;
    }
}
