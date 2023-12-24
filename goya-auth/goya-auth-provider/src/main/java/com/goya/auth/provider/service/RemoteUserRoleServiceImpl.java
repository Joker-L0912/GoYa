package com.goya.auth.provider.service;

import com.goya.auth.model.po.GoYaRole;
import com.goya.auth.provider.repository.GoYaRoleRepository;
import com.goya.core.constant.CacheConstants;
import com.goya.core.utils.JsonUtils;
import com.goya.issue.auth.api.RemoteUserRoleService;
import com.goya.redis.utils.RedisUtils;
import com.goya.security.dto.CustomUser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author limoum0u
 * @date 23/12/24 15:33
 */
public class RemoteUserRoleServiceImpl implements RemoteUserRoleService {

    private RedisUtils redisUtils;

    private GoYaRoleRepository roleRepository;

    public void setRedisUtils(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    @Override
    public List<GoYaRole> getUserRoleList(String token) {
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
}
