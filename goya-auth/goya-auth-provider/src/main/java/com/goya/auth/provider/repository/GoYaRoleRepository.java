package com.goya.auth.provider.repository;

import com.goya.auth.model.po.GoYaRole;
import com.goya.hibernate.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoYaRoleRepository extends BaseRepository<GoYaRole, Long> {

}