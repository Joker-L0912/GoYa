package com.goya.auth.provider.repository;

import com.goya.auth.model.po.GoYaUser;
import com.goya.hibernate.repository.BaseRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author limoum0u
 * @date 23/11/18 20:44
 */
@Repository
public interface UserRepository extends BaseRepository<GoYaUser, Long> {
    Optional<GoYaUser> findGoYaUserByUsername(String username);
}
