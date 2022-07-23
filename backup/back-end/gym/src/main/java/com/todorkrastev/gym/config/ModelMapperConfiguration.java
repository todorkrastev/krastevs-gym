package com.todorkrastev.gym.config;

import com.todorkrastev.gym.model.dto.RegisterDTO;
import com.todorkrastev.gym.model.entity.User;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Component;


//TODO: Could be also configuration
@Component
public class ModelMapperConfiguration {

    private final PasswordEncoder passwordEncoder;

    public ModelMapperConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();


        Converter<String, String> passwordHash = ctx -> ctx.getSource() == null ? null :
                passwordEncoder.encode(ctx.getSource());

        mapper.createTypeMap(RegisterDTO.class, User.class)
                .addMappings(mpr -> mpr.using(passwordHash)
                        .map(RegisterDTO::getPassword, User::setPassword));


        return mapper;
    }

}
