package com.todorkrastev.gym.service.impl;

import com.todorkrastev.gym.model.entity.Role;
import com.todorkrastev.gym.model.entity.enums.RoleCategoryName;
import com.todorkrastev.gym.repository.RoleRepository;
import com.todorkrastev.gym.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> findByRole(RoleCategoryName roleCategoryName) {
        return null;
        //return this.roleRepository.findByRole(roleCategoryName);
    }
}
