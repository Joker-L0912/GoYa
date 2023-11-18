package com.goya.user.api.service;


import com.goya.core.exception.user.UserException;
import com.goya.user.model.po.GoYaUser;
import org.hibernate.service.spi.ServiceException;

/**
 * 用户服务
 *
 */
public interface RemoteUserService {

    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @return 结果
     */
    GoYaUser getUserInfo(String username) throws UserException;

    /**
     * 通过手机号查询用户信息
     *
     * @param phoneNumber 手机号
     * @return 结果
     */
    GoYaUser getUserInfoByPhoneNumber(String phoneNumber) throws UserException;
}
