package com.goya.auth.provider.service;

import com.goya.auth.model.dto.CustomUser;
import com.goya.auth.model.po.GoYaRole;
import com.goya.auth.model.po.GoYaUser;
import com.goya.auth.provider.repository.UserRepository;
import com.goya.issue.model.po.GoYaMenu;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author limoum0u
 * @date 23/11/7 16:31
 */
@Service
@DubboService
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        GoYaUser user = userRepository.findGoYaUserByUsername(username).orElseThrow(() -> new RuntimeException(
                "用户名或密码错误"));
        Set<GoYaRole> roles = user.getRole();
        Set<String> menuPermits = new HashSet<>();
        for (GoYaRole role : roles) {
            Set<GoYaMenu> menus = role.getMenus();
            for (GoYaMenu menu : menus) {
                menuPermits.add(menu.getPerms());
            }
        }
        return new CustomUser(user.getUserId(), user.getUsername(), user.getPassword(), user.getPhonenumber(),
                menuPermits, Collections.emptyList());
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
