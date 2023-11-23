package com.goya.menu.model.po;

import com.goya.hibernate.model.po.BaseModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author limoum0u
 * @date 23/11/21 23:03
 */
@ToString(callSuper = true)
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "goya_menu", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name", name = "name")
})
@org.hibernate.annotations.Table(appliesTo = "goya_menu", comment = "菜单")
public class GoYaMenu extends BaseModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    /**
     * 资源名称
     */
    @Column(name="name")
    private String name;

    /**
     * 资源URL
     */
    @Column(name="url")
    private String url;

    /**
     * 类型   1：菜单  2：按钮
     */
    @Column(name="type")
    private Integer type;

    /**
     * 排序
     */
    @Column(name="sort")
    private Integer sort;

    /**
     * 备注
     */
    @Column(name="note")
    private String note;

    /**
     * 父菜单ID，一级菜单为0
     */
    @Column(name="parent_id")
    private Integer parentId;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        GoYaMenu goYaMenu = (GoYaMenu) o;
        return getId() != null && Objects.equals(getId(), goYaMenu.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
