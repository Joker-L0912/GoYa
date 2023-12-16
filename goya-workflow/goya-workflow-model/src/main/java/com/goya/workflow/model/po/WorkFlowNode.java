package com.goya.workflow.model.po;

import com.goya.hibernate.model.po.BaseModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

/**
 * @author limoum0u
 * @date 23/12/12 17:54
 */
@ToString(callSuper = true)
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "goya_flow_node", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name", name = "name")
})
@org.hibernate.annotations.Table(appliesTo = "goya_flow_node", comment = "节点信息")
public class WorkFlowNode extends BaseModel {

    @Id
    @Column(columnDefinition = "INT UNSIGNED COMMENT 'ID'")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '节点名'")
    private String name;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '节点类型'")
    private String type;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '节点颜色'")
    private String color;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '节点是否需要提交表单'")
    private String needSubmitForm;

    public WorkFlowNode(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        WorkFlowNode that = (WorkFlowNode) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
