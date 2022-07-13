package com.todorkrastev.gym.model.entity;

import com.todorkrastev.gym.model.entity.enums.RoleCategoryName;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    private RoleCategoryName role;

    @Enumerated(EnumType.STRING)
    public RoleCategoryName getRole() {
        return role;
    }

    public void setRole(RoleCategoryName role) {
        this.role = role;
    }
}