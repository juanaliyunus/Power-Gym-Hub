package com.work.baseapp.repository;

import com.work.baseapp.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAppRepository extends JpaRepository<UserApp, String> {
}