package com.work.baseapp.service;

import com.work.baseapp.constant.ERole;
import com.work.baseapp.entity.Role;

public interface RoleService {
    Role getOrSave(ERole role);
}