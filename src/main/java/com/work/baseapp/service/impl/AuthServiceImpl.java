package com.work.baseapp.service.impl;

import com.work.baseapp.constant.ERole;
import com.work.baseapp.dto.request.LoginRequest;
import com.work.baseapp.dto.request.RegisterRequest;
import com.work.baseapp.dto.response.LoginResponse;
import com.work.baseapp.dto.response.RegisterResponse;
import com.work.baseapp.entity.Role;
import com.work.baseapp.service.AuthService;
import com.work.baseapp.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final RoleService roleService;
    @Override
    public RegisterResponse register(RegisterRequest request) {
//        untuk role
        Role role = roleService.getOrSave(ERole.ROLE_USER);


        return null;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        return null;
    }
}
