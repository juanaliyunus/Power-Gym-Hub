package com.work.baseapp.service;

import com.work.baseapp.entity.UserApp;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserAppService extends UserDetailsService {
    UserApp loadUserById(String id);
    UserApp getUser(String id);
    UserApp findByUsername(String username);

}
