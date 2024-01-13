package com.goya.interact.model.po;

import com.goya.hibernate.model.po.BaseModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author limoum0u
 * @date 23/12/29 11:13
 */
@ToString(callSuper = true)
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "goya_comment", uniqueConstraints = {
//        @UniqueConstraint(columnNames = "id", name = "id")
})
@Comment("评论表")
public class GoyaComment extends BaseModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 评论主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 父评论id
     */
    @Column(name = "pid")
    private String pid;

    /**
     * 所属问题
     */
    @Column(name = "issue_name")
    private String issueName;

    /**
     * 评论类型：对人评论，对项目评论，对资源评论
     */
    @Column(name = "type")
    private Integer type;

    /**
     * 评论者id
     */
    @Column(name = "from_id")
    private String fromId;

    /**
     * 评论者名字
     */
    @Column(name = "from_name")
    private String fromName;

    /**
     * 被评论者id
     */
    @Column(name = "to_id")
    private String toId;

    /**
     * 被评论者名字
     */
    @Column(name = "to_name")
    private String toName;


    /**
     * 评论内容
     */
    @Column(name = "content")
    private String content;
}
