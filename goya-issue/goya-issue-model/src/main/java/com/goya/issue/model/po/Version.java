package com.goya.issue.model.po;

import com.goya.hibernate.model.po.BaseModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author limoum0u
 * @date 23/10/18 21:35
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "version", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name", name = "name")
})
@org.hibernate.annotations.Table(appliesTo = "version", comment = "版本")
public class Version extends BaseModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * name
     */
    @Column(name = "name")
    private String name;

    /**
     * 项目
     */
    @Column(name = "project_id")
    private Integer projectId;

    /**
     * 状态
     */
    @Column(name = "status")
    private String status;
}
