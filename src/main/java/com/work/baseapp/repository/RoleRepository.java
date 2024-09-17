package com.work.baseapp.repository;

import com.work.baseapp.constant.ERole;
import com.work.baseapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByRole(ERole role);
}