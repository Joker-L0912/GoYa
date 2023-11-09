package com.goya.auth.provider.repository;

import com.goya.auth.model.po.GoYaUser;
import com.goya.hibernate.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @author limoum0u
 * @date 23/11/8 14:28
 */
@Repository
public interface UserRepository extends BaseRepository<GoYaUser, Long> {
    GoYaUser getByUsername(String username);
}
