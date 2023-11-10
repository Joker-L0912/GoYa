package com.goya.hibernate.model.po;

import jakarta.persistence.metamodel.SingularAttribute;

import java.util.Date;

/**
 * @author limoum0u
 * @date 23/11/10 15:54
 */
public class BaseModel_ {
    public static volatile SingularAttribute<BaseModel, Date> createdAt;
    public static volatile SingularAttribute<BaseModel, Date> updatedAt;
    public static volatile SingularAttribute<BaseModel, String> createdBy;
    public static volatile SingularAttribute<BaseModel, String> updatedBy;
}
