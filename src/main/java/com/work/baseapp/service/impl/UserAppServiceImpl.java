package com.work.baseapp.service.impl;

import com.work.baseapp.entity.UserApp;
import com.work.baseapp.repository.UserAppRepository;
import com.work.baseapp.service.UserAppService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserAppServiceImpl implements UserAppService {
    private final UserAppRepository userAppRepository;
    @Override
    public UserApp loadUserById(String id) {
        return userAppRepository.findById(id)
                .orElseThrow(()->new UsernameNotFoundException("user not found"));
    }

    @Override
    public UserApp getUser(String id) {
        return userAppRepository.getById(id)
                .orElseThrow(()->new UsernameNotFoundException("user not found"));
    }

    @Override
    public UserApp findByUsername(String username) {
        return userAppRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("user not found"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAppRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("user not found"));
    }
}
