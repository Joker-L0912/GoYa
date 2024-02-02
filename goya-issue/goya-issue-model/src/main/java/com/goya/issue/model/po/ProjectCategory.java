package com.goya.issue.model.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.goya.hibernate.model.po.BaseModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author limoum0u
 * @date 23/11/9 16:20
 */
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project_category", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name", name = "name"),
})
@Comment("项目类别表")
@JsonIgnoreProperties({"createTime", "updateTime", "createBy", "updateBy"})
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

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        ProjectCategory that = (ProjectCategory) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
