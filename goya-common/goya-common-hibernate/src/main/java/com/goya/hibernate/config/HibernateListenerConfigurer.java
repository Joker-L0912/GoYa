package com.goya.hibernate.config;

import com.goya.hibernate.listener.IgnoreNullEventListener;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.context.annotation.Configuration;

/**
 * @author limoum0u
 * @date 23/11/10 14:43
 */
@Configuration
public class HibernateListenerConfigurer {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @PostConstruct
    protected void init() {
        SessionFactoryImpl sessionFactory = entityManagerFactory.unwrap(SessionFactoryImpl.class);
        EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
        registry.getEventListenerGroup(EventType.MERGE).clear();
        registry.getEventListenerGroup(EventType.MERGE).prependListener(IgnoreNullEventListener.INSTANCE);
    }

}
