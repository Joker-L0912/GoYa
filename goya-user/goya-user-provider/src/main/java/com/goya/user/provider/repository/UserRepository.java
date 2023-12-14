package com.goya.user.provider.repository;

import com.goya.hibernate.repository.BaseRepository;
import com.goya.user.model.dto.GoYaUserDTO;
import com.goya.user.model.po.GoYaUser;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author limoum0u
 * @date 23/11/18 20:44
 */
public interface UserRepository extends BaseRepository<GoYaUser, Long> {
    Optional<GoYaUser> findGoYaUserByUsername(String username);

    /**
     * 通过username 模糊查询
     *
     * @param username
     * @return
     */
    @Query(value = "select new com.goya.user.model.dto.GoYaUserDTO(u.userId, u.username, u.nickName, u.avatar) from " +
            "GoYaUser u where u.username like %?1%")
    List<GoYaUserDTO> findByUsername(String username);

}
