package com.work.baseapp.controller;

import com.work.baseapp.dto.request.LoginRequest;
import com.work.baseapp.dto.request.RegisterRequest;
import com.work.baseapp.dto.response.LoginResponse;
import com.work.baseapp.dto.response.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class AuthController {
    // 1. login (USER, ADMIN)
    public ResponseEntity<CommonResponse<LoginResponse>> login(@RequestBody LoginRequest request) {
        return null;
    }

    // 2. register (USER)
    public ResponseEntity<CommonResponse<RegisterResponse>> register(@RequestBody RegisterRequest request) {
        return null;
    }

}
