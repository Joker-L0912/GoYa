package com.goya.issue.model.po;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author limoum0u
 * @date 23/10/18 21:31
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name", name = "name")
})
@org.hibernate.annotations.Table(appliesTo = "project", comment = "项目表")
public class Project extends BaseModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * name
     */
    @Column(name = "name")
    private String name;

    /**
     * 图标
     */
    @Column(name = "icon", columnDefinition = "VARCHAR(50) COMMENT '图标'")
    private String icon;

    /**
     * 关键字
     */
    @Column(name = "keyword", columnDefinition = "VARCHAR(50) COMMENT '关键字'")
    private String keyword;

    /**
     * 项目描述
     */
    @Column(name = "description", columnDefinition = "VARCHAR(255) COMMENT '项目描述'")
    private String description;

    /**
     * 项目类型
     */
    @Column(name = "category", columnDefinition = "VARCHAR(50) COMMENT '项目类别'")
    private String category;

    /**
     * 项目类别
     */
    @Column(name = "type", columnDefinition = "VARCHAR(50) COMMENT '项目类型'")
    private String type;

    /**
     * 项目主管
     */
    @Column(name = "manager", columnDefinition = "VARCHAR(50) COMMENT '项目主管'")
    private String manager;


    /**
     * 项目状态
     */
    @Column(name = "status", columnDefinition = "VARCHAR(10) COMMENT '项目状态'")
    private String status;
}
