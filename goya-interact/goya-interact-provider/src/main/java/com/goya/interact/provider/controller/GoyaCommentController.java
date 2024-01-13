package com.goya.interact.provider.controller;

import com.goya.interact.model.po.GoyaComment;
import com.goya.interact.provider.service.GoyaCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author limoum0u
 * @date 23/12/29 17:43
 */
@RestController
@RequestMapping("/comment")
public class GoyaCommentController {
    private GoyaCommentService goyaCommentService;

    @GetMapping
    public List<GoyaComment> getComment(@RequestParam("issueName") String issueName) {
        return goyaCommentService.getComment(issueName);
    }


    @Autowired
    public void setGoyaCommentService(GoyaCommentService goyaCommentService) {
        this.goyaCommentService = goyaCommentService;
    }
}
