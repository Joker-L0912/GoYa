package com.goya.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.goya.user.model.po.GoYaUser}
 */
@Data
@AllArgsConstructor
public class GoYaUserDTO implements Serializable {
    Long userId;
    String username;
    String nickName;
    String avatar;
}