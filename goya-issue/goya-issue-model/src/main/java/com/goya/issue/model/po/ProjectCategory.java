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
@Table(name = "project_category", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name", name = "name")
})
@org.hibernate.annotations.Table(appliesTo = "project_category", comment = "项目类别表")
public class ProjectCategory extends BaseModel implements Serializable {
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
     * 状态
     */
    @Column(name = "status", columnDefinition = "VARCHAR(10) COMMENT '状态 0 可用 1 不可用'")
    private String status;
}
