package com.goya.issue.service.repository;

import com.goya.hibernate.repository.BaseRepository;
import com.goya.issue.model.po.GoYaMenu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface GoYaMenuRepository extends BaseRepository<GoYaMenu, Long> {
}