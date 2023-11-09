package com.goya.issue.service.dubbo;


import com.goya.core.exception.user.UserException;
import com.goya.issue.api.RemoteUserService;
import com.goya.issue.model.SysUser;
import com.goya.issue.model.dto.LoginUser;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

/**
 * @author Limou
 * @date 2023/10/01 14:44
 **/
@RequiredArgsConstructor
@Service
@DubboService
public class RemoteUserServiceImpl implements RemoteUserService {
    @Override
    public LoginUser getUserInfo(String username) throws UserException {
        return null;
    }

    @Override
    public LoginUser getUserInfoByPhoneNumber(String phoneNumber) throws UserException {
        return null;
    }

    @Override
    public LoginUser getUserInfoByEmail(String email) throws UserException {
        return null;
    }

    @Override
    public Boolean registerUserInfo(SysUser sysUser) throws UserException, ServiceException {
        return null;
    }

    @Override
    public String selectUserNameById(Long userId) {
        return null;
    }

//    private final SysUserMapper userMapper;
//
//    private final SysUserService userService;
//
//    @Override
//    public LoginUser getUserInfo(String username) throws UserException {
//        SysUser sysUser = userMapper.selectOne(new LambdaQueryWrapper<SysUser>()
//                .select(SysUser::getUserName, SysUser::getStatus)
//                .eq(SysUser::getUserName, username));
//        if (ObjectUtil.isNull(sysUser)) {
//            throw new UserException("user.blocked", username);
//        }
//        if (UserStatus.DISABLE.getCode().equals(sysUser.getStatus())) {
//            throw new UserException("user.blocked", username);
//        }
//        // 框架登录不限制从什么表查询 只要最终构建出 LoginUser 即可
//        // 此处可根据登录用户的数据不同 自行创建 loginUser 属性不够用继承扩展就行了
//        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(SysUser::getUserName, username);
//        SysUser user = userMapper.selectOne(queryWrapper);
//        return buildLoginUser(user);
//    }
//
//    @Override
//    public LoginUser getUserInfoByPhoneNumber(String phoneNumber) throws UserException {
//        return null;
//    }
//
//    @Override
//    public LoginUser getUserInfoByEmail(String email) throws UserException {
//        return null;
//    }
//
//    @Override
//    public Boolean registerUserInfo(SysUser sysUser) throws UserException, ServiceException {
//        String username = sysUser.getUserName();
//        if (!userService.checkUserNameUnique(sysUser)) {
//            throw new UserException("user.register.save.error", username);
//        }
//        return userService.registerUser(sysUser);
//    }
//
//    @Override
//    public String selectUserNameById(Long userId) {
//        return null;
//    }
//
//    /**
//     * 构建登录用户
//     */
//    private LoginUser buildLoginUser(SysUser user) {
//        LoginUser loginUser = new LoginUser();
//        loginUser.setUserId(user.getUserId());
//        loginUser.setDeptId(user.getDeptId());
//        loginUser.setUsername(user.getUserName());
//        loginUser.setPassword(user.getPassword());
//        loginUser.setUserType(user.getUserType());
//        return loginUser;
//    }
}