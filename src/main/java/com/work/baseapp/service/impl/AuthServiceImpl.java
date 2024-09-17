package com.work.baseapp.service.impl;

import com.work.baseapp.constant.ERole;
import com.work.baseapp.dto.request.LoginRequest;
import com.work.baseapp.dto.request.RegisterRequest;
import com.work.baseapp.dto.response.LoginResponse;
import com.work.baseapp.dto.response.RegisterResponse;
import com.work.baseapp.entity.Role;
import com.work.baseapp.entity.User;
import com.work.baseapp.entity.UserApp;
import com.work.baseapp.repository.UserAppRepository;
import com.work.baseapp.repository.UserRepository;
import com.work.baseapp.service.AuthService;
import com.work.baseapp.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final RoleService roleService;
    private final UserAppRepository userAppRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public RegisterResponse register(RegisterRequest request) {
        Role roleUser = roleService.getOrSave(ERole.ROLE_USER);
        String hashPassword = passwordEncoder.encode(request.getPassword());

        UserApp account = UserApp.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(hashPassword)
                .role(List.of(roleUser))
                .isActive(true)
                .build();

        userAppRepository.saveAndFlush(account);

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .fullName(request.getFirstName() + " " + request.getLastName())
                .userApp(account)
                .build();

        userRepository.saveAndFlush(user);

        List<String> roles = account.getRole().stream().map(role -> role.getRole().name()).toList();


        return RegisterResponse.builder()
                .username(account.getUsername())
                .roles(roles)
                .build();
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        );
        Authentication authenticate = authenticationManager.authenticate(authentication);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        UserApp userApp = jwt
        return null;
    }
}
