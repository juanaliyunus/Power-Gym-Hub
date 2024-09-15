package com.work.baseapp.repository;

import com.work.baseapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}