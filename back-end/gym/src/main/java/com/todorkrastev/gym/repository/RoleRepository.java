package com.todorkrastev.gym.repository;

import com.todorkrastev.gym.model.entity.Role;
import com.todorkrastev.gym.model.entity.enums.RoleCategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(RoleCategoryName role);
}
