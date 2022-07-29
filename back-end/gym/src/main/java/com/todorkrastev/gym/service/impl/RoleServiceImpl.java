package com.todorkrastev.gym.service.impl;

import com.todorkrastev.gym.model.entity.Role;
import com.todorkrastev.gym.model.entity.enums.RoleCategoryName;
import com.todorkrastev.gym.repository.RoleRepository;
import com.todorkrastev.gym.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> findByRole(RoleCategoryName roleCategoryName) {
        return this.roleRepository.findByRole(roleCategoryName);
    }

    @Override
    public void init() {
        if (this.roleRepository.count() == 0) {
            Arrays
                    .stream(RoleCategoryName.values())
                    .forEach(roleCategoryName -> {
                        Role role = new Role().setRole(roleCategoryName);

                        this.roleRepository.save(role);
                    });
        }
    }
}
