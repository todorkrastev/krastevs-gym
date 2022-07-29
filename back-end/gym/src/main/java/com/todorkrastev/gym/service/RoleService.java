package com.todorkrastev.gym.service;

import com.todorkrastev.gym.model.entity.Role;
import com.todorkrastev.gym.model.entity.enums.RoleCategoryName;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    Optional<Role> findByRole(RoleCategoryName roleCategoryName);
}
