package com.goya.auth.provider.service;

import com.goya.auth.model.dto.CustomUser;
import com.goya.auth.model.po.GoYaRole;
import com.goya.auth.model.po.GoYaUser;
import com.goya.auth.provider.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

/**
 * @author limoum0u
 * @date 23/11/7 16:31
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        GoYaUser user =
                userRepository.findGoYaUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        Set<GoYaRole> role = user.getRole();
        return new CustomUser(user.getUserId(), user.getUsername(), user.getPassword(), user.getPhonenumber(),
                Collections.emptyList());
    }
}
