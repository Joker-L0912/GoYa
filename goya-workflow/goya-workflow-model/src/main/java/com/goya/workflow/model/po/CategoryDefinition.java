package com.goya.workflow.model.po;

import com.goya.hibernate.model.po.BaseModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

/**
 * @author limoum0u
 * @date 23/12/2 23:03
 */
@ToString(callSuper = true)
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "category_def_rel")
@org.hibernate.annotations.Table(appliesTo = "category_def_rel", comment = "类别和流程定义关联表")
public class CategoryDefinition extends BaseModel {

    @Id
    @Column(columnDefinition = "INT UNSIGNED COMMENT 'ID'")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '类别key'", nullable = false)
    private Long categoryKey;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '流程示例key'", nullable = false)
    private String processDefinitionKey;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ?
                ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ?
                ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        CategoryDefinition that = (CategoryDefinition) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ?
                ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() :
                getClass().hashCode();
    }
}
