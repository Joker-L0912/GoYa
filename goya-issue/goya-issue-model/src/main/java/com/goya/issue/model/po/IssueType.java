package com.goya.issue.model.po;

import com.goya.hibernate.model.po.BaseModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author limoum0u
 * @date 23/10/20 22:10
 */
@ToString(callSuper = true)
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "issue_type", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name", name = "name")
})
@Comment("问题类型表")
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

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        IssueType issueType = (IssueType) o;
        return getId() != null && Objects.equals(getId(), issueType.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
