package com.goya.user.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.goya.user.model.po.GoYaUser}
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