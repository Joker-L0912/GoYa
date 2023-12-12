package com.goya.workflow.model.po;

import com.goya.hibernate.model.po.BaseModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

/**
 * @author limoum0u
 * @date 23/12/2 23:31
 */
@ToString
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "issue_instance_rel", uniqueConstraints = {
        @UniqueConstraint(name = "id", columnNames = {"id"}),
        @UniqueConstraint(name = "uc_issueinstancekey", columnNames = {"issueName"})
})
@org.hibernate.annotations.Table(appliesTo = "issue_instance_rel", comment = "问题流程关联表")
public class IssueInstanceKey extends BaseModel {

    @Id
    @Column(columnDefinition = "INT UNSIGNED COMMENT 'ID'")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '问题key'", nullable = false)
    private String issueName;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '流程实例key'", nullable = false)
    private String processInstanceKey;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        IssueInstanceKey that = (IssueInstanceKey) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
