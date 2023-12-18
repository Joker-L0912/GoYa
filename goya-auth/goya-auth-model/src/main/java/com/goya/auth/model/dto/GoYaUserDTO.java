package com.goya.auth.model.dto;

import com.goya.auth.model.po.GoYaUser;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link GoYaUser}
 */
@Data
public class GoYaUserDTO implements Serializable {
    Long userId;
    String username;
    String nickName;
    String avatar;

    public GoYaUserDTO(Long userId, String username, String nickName, String avatar) {
        this.userId = userId;
        this.username = username;
        this.nickName = nickName;
        this.avatar = avatar;
    }
}