package com.goya.auth.model.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.goya.hibernate.model.po.BaseModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

/**
 * @author limoum0u
 * @date 23/12/21 16:12
 */
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "goya_role", indexes = {
        @Index(name = "idx_role_id", columnList = "role_id")
})
@Comment("角色表")
@JsonIgnoreProperties({"createdAt", "updatedAt", "createdBy", "updatedBy", "status", "delFlag", "remark"})
public class GoYaRole extends BaseModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 465972765146972L;

    /**
     * 角色ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 角色编码
     */
    @Column(name = "role_code")
    private String roleCode;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "goya_role_menu_rel",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "menu_id", referencedColumnName = "menu_id")})
    private Set<GoYaMenu> menus;

    /**
     * 角色状态（0正常 1停用）
     */
    @Column(name = "status")
    private String status;

    /**
     * 删除标志（1代表存在 0代表删除）
     */
    @Column(name = "del_flag")
    private String delFlag;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;
}
