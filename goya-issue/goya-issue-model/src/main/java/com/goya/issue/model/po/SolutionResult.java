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
 * @date 23/10/18 21:33
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "solution_result", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name", name = "name")
})
@org.hibernate.annotations.Table(appliesTo = "solution_result", comment = "解决结果表")
public class SolutionResult extends BaseModel implements Serializable {

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
}
