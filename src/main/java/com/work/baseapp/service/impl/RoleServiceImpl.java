package com.work.baseapp.service.impl;

import com.work.baseapp.constant.ERole;
import com.work.baseapp.entity.Role;
import com.work.baseapp.repository.RoleRepository;
import com.work.baseapp.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role getOrSave(ERole role) {
        Optional<Role> optionalRole = roleRepository.findByRole(role);
        // if role available return it
        if (optionalRole.isPresent()){
            return optionalRole.get();
        }

        // role not available create new
        Role currentRole = Role.builder()
                .role(role)
                .build();
        return null;
    }
}
