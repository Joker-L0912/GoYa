package com.goya.auth.provider.service;

import com.goya.auth.model.dto.CustomUser;
import com.goya.user.api.service.RemoteUserService;
import com.goya.user.model.po.GoYaUser;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author limoum0u
 * @date 23/11/7 16:31
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @DubboReference
    private RemoteUserService remoteUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        GoYaUser goyaUser = remoteUserService.getUserInfo(username);
        if (Objects.isNull(goyaUser)) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        if ("1".equals(goyaUser.getStatus())) {
            throw new RuntimeException("账号已停用");
        }
        CustomUser customUser = new CustomUser();
        BeanUtils.copyProperties(goyaUser, customUser);
        return customUser;
    }
}
