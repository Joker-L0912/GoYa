package com.goya.workflow.provider.repository;

import com.goya.hibernate.repository.BaseRepository;
import com.goya.workflow.model.po.CategoryDefinition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDefinitionRepository extends BaseRepository<CategoryDefinition, Long> {

    @Query("select processDefinitionKey from CategoryDefinition where categoryKey = ?1")
    String findProcessDefinitionKeyByCategoryKey(Long categoryKey);
}