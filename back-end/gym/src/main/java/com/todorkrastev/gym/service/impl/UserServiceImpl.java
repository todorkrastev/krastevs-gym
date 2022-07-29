package com.todorkrastev.gym.service.impl;

import com.todorkrastev.gym.model.entity.Role;
import com.todorkrastev.gym.model.entity.User;
import com.todorkrastev.gym.model.entity.enums.RoleCategoryName;
import com.todorkrastev.gym.repository.RoleRepository;
import com.todorkrastev.gym.repository.UserRepository;
import com.todorkrastev.gym.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final String adminPass;
    private final String moderatorPass;
    private final String userPass;


    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           @Value("${app.default.admin.password}") String adminPass,
                           @Value("${app.default.moderator.password}") String moderatorPass,
                           @Value("${app.default.user.password}") String userPass) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.adminPass = adminPass;
        this.moderatorPass = moderatorPass;
        this.userPass = userPass;
    }


    @Override
    public boolean existsByUsername(String username) {
        return false;
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    @Override
    public void init() {
        if (this.userRepository.count() == 0) {

            Optional<Role> getAdminByRole = this.roleRepository.findByRole(RoleCategoryName.ADMIN);
            Optional<Role> getModeratorRole = this.roleRepository.findByRole(RoleCategoryName.MODERATOR);
            Optional<Role> getUserRole = this.roleRepository.findByRole(RoleCategoryName.USER);

            if (getAdminByRole.isPresent() && getModeratorRole.isPresent() && getUserRole.isPresent()) {
                Role admin = getAdminByRole.get();
                Role moderator = getModeratorRole.get();
                Role user = getUserRole.get();

                initAdmin(Set.of(admin, moderator));
                initModerator(Set.of(moderator));
                initUser(Set.of(user));
            }
        }
    }

    private void initAdmin(Set<Role> roles) {
        User admin = new User()
                .setUsername("admin")
                .setEmail("admin@example.com")
                .setPassword(this.passwordEncoder.encode(this.adminPass))
                .setRoles(roles);

        this.userRepository.save(admin);
    }

    private void initModerator(Set<Role> roles) {
        User moderator = new User()
                .setUsername("moderator")
                .setEmail("moderator@example.com")
                .setPassword(this.passwordEncoder.encode(this.moderatorPass))
                .setRoles(roles);

        this.userRepository.save(moderator);
    }

    private void initUser(Set<Role> roles) {
        User user = new User()
                .setUsername("johndoe")
                .setEmail("johndoe@example.com")
                .setPassword(this.passwordEncoder.encode(this.userPass))
                .setRoles(roles);

        this.userRepository.save(user);
    }
}
