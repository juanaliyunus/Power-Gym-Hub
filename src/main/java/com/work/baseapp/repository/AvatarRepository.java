package com.work.baseapp.repository;

import com.work.baseapp.entity.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvatarRepository extends JpaRepository<Avatar, String> {
}