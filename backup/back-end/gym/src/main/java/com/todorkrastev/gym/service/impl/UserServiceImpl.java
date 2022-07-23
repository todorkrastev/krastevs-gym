package com.todorkrastev.gym.service.impl;

import com.todorkrastev.gym.model.dto.RegisterDTO;
import com.todorkrastev.gym.model.entity.Role;
import com.todorkrastev.gym.model.entity.User;
import com.todorkrastev.gym.model.entity.enums.RoleCategoryName;
import com.todorkrastev.gym.repository.RoleRepository;
import com.todorkrastev.gym.repository.UserRepository;
import com.todorkrastev.gym.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final UserDetailsService appUserDetailService;
    private String adminPass;
    private String moderatorPass;
    private String userPass;


    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           ModelMapper modelMapper,
                           UserDetailsService appUserDetailService,
                           @Value("${app.default.admin.password}") String adminPass,
                           @Value("${app.default.moderator.password}") String moderatorPass,
                           @Value("${app.default.user.password}") String userPass) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.appUserDetailService = appUserDetailService;
        this.adminPass = adminPass;
        this.moderatorPass = moderatorPass;
        this.userPass = userPass;
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

                initAdmin(List.of(admin, moderator));
                initModerator(List.of(moderator));
                initUser(List.of(user));
            }
        }
    }

    private void initAdmin(List<Role> roles) {
        User admin = new User()
                .setUsername("admin")
                .setEmail("admin@example.com")
                .setPassword(this.passwordEncoder.encode(this.adminPass))
                .setRoles(roles);

        this.userRepository.save(admin);
    }

    private void initModerator(List<Role> roles) {
        User moderator = new User()
                .setUsername("moderator")
                .setEmail("moderator@example.com")
                .setPassword(this.passwordEncoder.encode(this.moderatorPass))
                .setRoles(roles);

        this.userRepository.save(moderator);
    }

    private void initUser(List<Role> roles) {
        User user = new User()
                .setUsername("johndoe")
                .setEmail("johndoe@example.com")
                .setPassword(this.passwordEncoder.encode(this.userPass))
                .setRoles(roles);

        this.userRepository.save(user);
    }

    public void registerAndLogin(RegisterDTO registerDTO) {
        User newUser = this.modelMapper.map(registerDTO, User.class);

        //TODO: Check if the mapping is working correctly, especially for the hashing of the password.
        //TODO: It is already implemented a hashing mapping in ModelMapper

        this.userRepository.save(newUser);

        UserDetails userDetails =
                this.appUserDetailService.loadUserByUsername(newUser.getEmail());

        Authentication auth =
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        userDetails.getPassword(),
                        userDetails.getAuthorities()
                );

        SecurityContextHolder.
                getContext().
                setAuthentication(auth);
    }
}
