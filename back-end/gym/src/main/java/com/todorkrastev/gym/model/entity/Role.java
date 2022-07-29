package com.todorkrastev.gym.model.entity;

import com.todorkrastev.gym.model.entity.enums.RoleCategoryName;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    private String name;

    public Role() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
    private RoleCategoryName role;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    public RoleCategoryName getRole() {
        return role;
    }

    public Role setRole(RoleCategoryName role) {
        this.role = role;
        return this;
    }

     */
}