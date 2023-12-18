package com.goya.auth.model.po;

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
 * @date 23/11/8 10:50
 */
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "user", indexes = {
        @Index(name = "idx_goyauser_user_name", columnList = "user_name")
}, uniqueConstraints = {
        @UniqueConstraint(name = "user_name", columnNames = {"user_name"})
})
@org.hibernate.annotations.Table(appliesTo = "user", comment = "用户")
public class GoYaUser extends BaseModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    /**
     * 部门ID
     */
    @Column(name = "dept_id")
    private Long deptId;

    /**
     * 用户账号
     */
    @Column(name = "user_name")
    private String username;

    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 用户类型（sys_user系统用户）
     */
    @Column(name = "user_type")
    private String userType;

    /**
     * 用户邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 手机号码
     */
    @Column(name = "phonenumber")
    private String phonenumber;

    /**
     * 用户性别（0男 1女 2未知）
     */
    @Column(name = "sex")
    private String sex;

    /**
     * 头像地址
     */
    @Column(name = "avatar")
    private String avatar;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 帐号状态（0正常 1停用）
     */
    @Column(name = "status")
    private String status;

    /**
     * 最后登录IP
     */
    @Column(name = "login_ip")
    private String loginIp;

    /**
     * 最后登录时间
     */
    @Column(name = "login_date")
    private Date loginDate;


    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ?
                ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ?
                ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        GoYaUser goYaUser = (GoYaUser) o;
        return getUserId() != null && Objects.equals(getUserId(), goYaUser.getUserId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ?
                ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() :
                getClass().hashCode();
    }
}
