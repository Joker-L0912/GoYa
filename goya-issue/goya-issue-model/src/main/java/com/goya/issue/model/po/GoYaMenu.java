package com.goya.issue.model.po;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.io.Serializable;
import java.util.Date;

/**
 * @author limoum0u
 * @date 23/12/21 17:02
 */
@ToString(callSuper = true)
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "goya_menu", uniqueConstraints = {
        @UniqueConstraint(columnNames = "menu_name", name = "menu_name")
})
@Comment("菜单权限表")
public class GoYaMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    @Id
    @GeneratedValue
    @Column(name = "menu_id")
    private Long menuId;

    /**
     * 菜单名称
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 父菜单ID
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 显示顺序
     */
    @Column(name = "order_num")
    private Integer orderNum;

    /**
     * 请求地址
     */
    @Column(name = "url")
    private String url;

    /**
     * 打开方式（menuItem页签 menuBlank新窗口）
     */
    @Column(name = "target")
    private String target;

    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    @Column(name = "menu_type")
    private String menuType;

    /**
     * 菜单状态（0显示 1隐藏）
     */
    @Column(name = "visible")
    private String visible;

    /**
     * 是否刷新（0刷新 1不刷新）
     */
    @Column(name = "is_refresh")
    private String isRefresh;

    /**
     * 权限标识
     */
    @Column(name = "perms")
    private String perms;

    /**
     * 菜单图标
     */
    @Column(name = "icon")
    private String icon;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

}
