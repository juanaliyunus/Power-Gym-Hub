package com.work.baseapp.repository;

import com.work.baseapp.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserAppRepository extends JpaRepository<UserApp, String> {
    Optional<UserApp> findByUsername(String username);
    Optional<UserApp> getById(String id);

}