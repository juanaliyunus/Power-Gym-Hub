package com.work.baseapp.repository;

import com.work.baseapp.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {
}