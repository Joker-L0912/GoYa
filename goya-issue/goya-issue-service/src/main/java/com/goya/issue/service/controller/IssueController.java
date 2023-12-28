package com.goya.issue.service.controller;

import com.goya.issue.model.dto.IssueListItemDTO;
import com.goya.issue.model.po.Issue;
import com.goya.issue.service.service.IssueService;
import com.goya.workflow.model.dto.TaskParam;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * 问题主表 前端控制器
 * </p>
 *
 * @author lizihan
 * @since 2023-10-06 04:28:42
 */
@RestController
@RequestMapping("/issue")
public class IssueController {

    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }


    /**
     * 根据名称和项目ID获取问题
     *
     * @param name 问题名称
     * @param projectId 项目ID
     * @return 问题对象
     * @throws Exception 如果发生异常
     */
    @GetMapping("/{name}")
    public Issue getByName(@PathVariable String name, @RequestParam Long projectId) throws Exception {
        Optional<Issue> issue = issueService.findByName(name, projectId);
        return issue.orElseThrow(() -> new Exception("issue not found"));
    }

    /**
     * 获取问题列表
     *
     * @param projectId 项目ID
     * @param pageNum 页码
     * @param pageSize 每页数量
     * @return 问题列表
     */
    @GetMapping
    public List<IssueListItemDTO> getIssueList(Long projectId,
                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                               @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {
        return issueService.getIssueList(pageNum, pageSize, projectId);
    }

    /**
     * 获取问题数量
     *
     * @param projectId 项目ID
     * @return 问题数量
     */
    @GetMapping("/count")
    public Long getCount(@RequestParam Long projectId) {
        return issueService.getCount(projectId);
    }

    /**
     * 新增问题
     *
     * @param issueMap 问题信息
     * @return 问题ID
     */
    @PostMapping
    public String addIssue(@RequestBody Map<String, String> issueMap) {
        return issueService.save(issueMap);
    }

    /**
     * 完成任务
     *
     * @param taskParam 任务参数
     * @return 任务ID
     */
    @PostMapping("/complete")
    public int completeTask(@RequestBody TaskParam taskParam) {
        return issueService.completeTask(taskParam);
    }

    @GetMapping("/myTask")
    public Page<IssueListItemDTO> getMyTask(@RequestParam Long projectId,
                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return issueService.getMyTask(projectId, pageNum, pageSize);
    }
}
