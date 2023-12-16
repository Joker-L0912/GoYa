package com.goya.issue.model.po;

import com.goya.hibernate.model.po.BaseModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author limoum0u
 * @date 23/10/15 15:35
 */
@ToString(callSuper = true)
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
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
    private IssueType issueType;

    /**
     * 项目
     */
    @ManyToOne(targetEntity = Project.class)
    @JoinColumn(name = "project_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "none", value =
            ConstraintMode.NO_CONSTRAINT))
    private Project project;

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
    private String solutionResult;

    /**
     * 影响版本
     */
    @ManyToOne(targetEntity = Version.class)
    @JoinColumn(name = "affected_version_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "none",
            value = ConstraintMode.NO_CONSTRAINT))
    private Version affectedVersion;

    /**
     * 修复版本
     */
    @ManyToOne(targetEntity = Version.class)
    @JoinColumn(name = "fix_version_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "none", value =
            ConstraintMode.NO_CONSTRAINT))
    private Version fixVersion;

    /**
     * 模块
     */
    @ManyToOne(targetEntity = ProjectModule.class)
    @JoinColumn(name = "module_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "none", value =
            ConstraintMode.NO_CONSTRAINT))
    private ProjectModule projectModule;

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

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Issue issue = (Issue) o;
        return getId() != null && Objects.equals(getId(), issue.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
