package com.goya.auth.provider.repository;

import com.goya.hibernate.repository.BaseRepository;
import com.goya.auth.model.po.GoYaMenu;
import org.springframework.stereotype.Repository;

@Repository
public interface GoYaMenuRepository extends BaseRepository<GoYaMenu, Long> {
}