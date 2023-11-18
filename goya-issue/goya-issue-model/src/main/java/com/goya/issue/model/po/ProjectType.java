package com.goya.issue.model.po;

import com.goya.hibernate.model.po.BaseModel;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * @author limoum0u
 * @date 23/11/9 16:20
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project_type", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name", name = "name")
})
@org.hibernate.annotations.Table(appliesTo = "project_type", comment = "项目类型表 如 business software")
public class ProjectType extends BaseModel implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    /**
     * name
     */
    @Column(name = "name", columnDefinition = "VARCHAR(50) COMMENT '名称'")
    private String name;
    /**
     * 图标
     */
    @Column(name = "icon", columnDefinition = "VARCHAR(50) COMMENT '图标'")
    private String icon;
    /**
     * 状态
     */
    @Column(name = "status", columnDefinition = "VARCHAR(10) COMMENT '状态 0 可用 1 不可用'")
    private String status;
}
