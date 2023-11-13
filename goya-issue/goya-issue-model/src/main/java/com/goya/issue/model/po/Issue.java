package com.goya.issue.model.po;

import com.goya.hibernate.model.po.BaseModel;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author limoum0u
 * @date 23/10/15 15:35
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "issue", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name", name = "name")
})
@org.hibernate.annotations.Table(appliesTo = "issue", comment = "问题")
public class Issue extends BaseModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(columnDefinition = "INT UNSIGNED COMMENT 'ID'")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '密钥'", nullable = false)
    private String name;

    /**
     * 摘要
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '摘要'", nullable = false)
    private String gist;

    /**
     * 类型
     */
    @ManyToOne(targetEntity = IssueType.class)
    @JoinColumn(name = "type_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "none", value =
            ConstraintMode.NO_CONSTRAINT))
    private IssueType typeId;

    /**
     * 项目
     */
    @ManyToOne(targetEntity = Project.class)
    @JoinColumn(name = "project_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "none", value =
            ConstraintMode.NO_CONSTRAINT))
    private Project projectId;

    /**
     * 描述
     */
    @Column(columnDefinition = "VARCHAR(1000) COMMENT '描述'")
    private String description;

    /**
     * 优先级
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '问题优先级'")
    private String issuePriority;
//    private Integer priorityId;

    /**
     * 状态
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '问题状态'")
    private String issueStatus;

    /**
     * 解决结果
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '解决结果'")
    private String solutionResultId;

    /**
     * 影响版本
     */
    @ManyToOne(targetEntity = Version.class)
    @JoinColumn(name = "affected_version_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "none",
            value = ConstraintMode.NO_CONSTRAINT))
    private Version affectedVersionId;

    /**
     * 修复版本
     */
    @ManyToOne(targetEntity = Version.class)
    @JoinColumn(name = "fix_version_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "none", value =
            ConstraintMode.NO_CONSTRAINT))
    private Version fixVersionId;

    /**
     * 模块
     */
    @ManyToOne(targetEntity = ProjectModule.class)
    @JoinColumn(name = "module_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "none", value =
            ConstraintMode.NO_CONSTRAINT))
    private ProjectModule moduleId;

    /**
     * epic_link
     */
    private Long epicLinkId;
    private String epicLinkName;

    /**
     * 报告人
     */
    private String reportedBy;

    /**
     * 经办人
     */
    private String handledBy;

    /**
     * 开发人员
     */
    private String developedBy;

    /**
     * 测试人员
     */
    private String testedBy;

}
