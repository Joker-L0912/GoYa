package com.goya.issue.auth.api;

import com.goya.auth.model.po.GoYaRole;

import java.util.List;

/**
 * @author limoum0u
 * @date 23/12/24 15:30
 */
public interface RemoteUserRoleService {

    public List<GoYaRole> getRoleMenuIds(String token);
}
