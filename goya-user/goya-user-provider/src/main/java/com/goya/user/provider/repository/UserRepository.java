package com.goya.user.provider.repository;

import com.goya.hibernate.repository.BaseRepository;
import com.goya.user.model.dto.GoYaUserDTO;
import com.goya.user.model.po.GoYaUser;

import java.util.Optional;

/**
 * @author limoum0u
 * @date 23/11/18 20:44
 */
public interface UserRepository extends BaseRepository<GoYaUser, Long> {
    Optional<GoYaUser> findGoYaUserByUsername(String username);

    GoYaUserDTO findByUsername(String username);

}
