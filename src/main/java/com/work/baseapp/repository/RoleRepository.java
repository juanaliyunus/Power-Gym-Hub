package com.work.baseapp.repository;

import com.work.baseapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}