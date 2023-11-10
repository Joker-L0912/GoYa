package com.goya.hibernate.listener;

import org.hibernate.bytecode.enhance.spi.LazyPropertyInitializer;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.event.internal.DefaultMergeEventListener;
import org.hibernate.event.spi.MergeContext;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.property.access.internal.PropertyAccessStrategyBackRefImpl;
import org.hibernate.type.Type;

import java.util.Map;

/**
 * @author limoum0u
 * @date 23/11/10 14:39
 */
public class IgnoreNullEventListener extends DefaultMergeEventListener {
    public static final IgnoreNullEventListener INSTANCE = new IgnoreNullEventListener();

    @Override
    protected void copyValues(EntityPersister persistent, Object entity, Object target,
                              SessionImplementor source, MergeContext copyCache) {
        //源目标
        Object[] original = persistent.getPropertyValues(entity);
        //存储目标
        Object[] targets = persistent.getPropertyValues(target);

        Type[] types = persistent.getPropertyTypes();

        Object[] copied = new Object[original.length];
        int len = types.length;
        for (int i = 0; i < len; i++) {
            if (original[i] == null ||
                    original[i] == LazyPropertyInitializer.UNFETCHED_PROPERTY ||
                    original[i] == PropertyAccessStrategyBackRefImpl.UNKNOWN
            ) {
                copied[i] = targets[i];
            } else {
                copied[i] = types[i].replace(original[i], targets[i], source, target, copyCache);
            }
        }

        persistent.setPropertyValues(target, copied);
    }
}
