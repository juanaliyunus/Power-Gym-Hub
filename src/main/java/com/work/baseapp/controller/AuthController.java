package com.work.baseapp.controller;

import com.work.baseapp.dto.request.LoginRequest;
import com.work.baseapp.dto.request.RegisterRequest;
import com.work.baseapp.dto.response.LoginResponse;
import com.work.baseapp.dto.response.CommonResponse;
import com.work.baseapp.dto.response.RegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping()
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
