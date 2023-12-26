package com.goya.auth.provider.service;

import com.goya.auth.model.dto.CustomUser;
import com.goya.auth.model.po.GoYaRole;
import com.goya.auth.provider.repository.GoYaRoleRepository;
import com.goya.auth.provider.repository.UserRepository;
import com.goya.core.constant.CacheConstants;
import com.goya.core.utils.JsonUtils;
import com.goya.issue.auth.api.RemoteUserRoleService;
import com.goya.redis.utils.RedisUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author limoum0u
 * @date 23/12/24 15:33
 */
@DubboService
@Service
public class RemoteUserRoleServiceImpl implements RemoteUserRoleService {

    private RedisUtils redisUtils;

    private GoYaRoleRepository roleRepository;

    private UserRepository userRepository;

    @Override
    public List<GoYaRole> getRoleMenuIds(String token) {
        List<GoYaRole> rolelist = new ArrayList<>();
        String s = redisUtils.get(CacheConstants.REDIS_TOKEN_PREFIX + token);
        CustomUser customUser = JsonUtils.parseObject(s, CustomUser.class);
        if (customUser == null) {
            return rolelist;
        }
        String username = customUser.getUsername();
//        roleRepository.
        return null;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRedisUtils(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    @Autowired
    public void setRoleRepository(GoYaRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
