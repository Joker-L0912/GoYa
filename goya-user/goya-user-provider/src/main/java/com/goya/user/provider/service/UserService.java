package com.goya.user.provider.service;

import com.goya.core.enums.ReturnCode;
import com.goya.core.exception.user.UserException;
import com.goya.user.api.service.RemoteUserService;
import com.goya.user.model.dto.GoYaUserDTO;
import com.goya.user.model.po.GoYaUser;
import com.goya.user.provider.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author limoum0u
 * @date 23/11/18 20:41
 */
@RequiredArgsConstructor
@Service
@DubboService
public class UserService implements RemoteUserService {

    private final UserRepository userRepository;
    @Override
    public GoYaUser getUserInfo(String username) throws UserException {
        return userRepository.findGoYaUserByUsername(username).orElseThrow(() -> new UserException(ReturnCode.USER_ERROR_A0201));
    }

    @Override
    public GoYaUser getUserInfoByPhoneNumber(String phoneNumber) throws UserException {
        return null;
    }

    // 查询用户的部分信息
    public List<GoYaUserDTO> getUserInfoPart(String username) throws UserException {
        return userRepository.findByUsername(username);
    }

    public GoYaUserDTO login(String username, String password) {
        return null;
    }
}