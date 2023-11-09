package com.goya.issue.model.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

/**
 * @author limoum0u
 * @date 23/10/15 15:37
 */

/**
 * 公共实体类
 */
@MappedSuperclass
@Data
@EntityListeners(value = AuditingEntityListener.class)
public class BaseModel {
    /**
     * created_at
     */
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createdAt;

    /**
     * updated_at
     */
    @LastModifiedBy
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updatedAt;

    /**
     * created_by
     */
    private String createdBy;

    /**
     * updated_by
     */
    private String updatedBy;
}
