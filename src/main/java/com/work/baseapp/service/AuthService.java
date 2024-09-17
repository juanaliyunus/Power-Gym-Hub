package com.work.baseapp.service;

import com.work.baseapp.dto.request.LoginRequest;
import com.work.baseapp.dto.request.RegisterRequest;
import com.work.baseapp.dto.response.LoginResponse;
import com.work.baseapp.dto.response.RegisterResponse;

public interface AuthService {
    RegisterResponse register(RegisterRequest request);
    LoginResponse login(LoginRequest request);
}
