package com.goya.issue.model.po;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * @author limoum0u
 * @date 23/10/20 22:10
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "issue_type", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name", name = "name")
})
@org.hibernate.annotations.Table(appliesTo = "issue_type", comment = "问题类型")
public class IssueType extends BaseModel implements Serializable {

    @Id
    @Column(columnDefinition = "INT UNSIGNED COMMENT 'ID'")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '类型名'", nullable = false)
    private String name;

    /**
     * 摘要
     */
    @Column(columnDefinition = "VARCHAR(50) COMMENT '展示名'", nullable = false)
    private String displayName;

}
