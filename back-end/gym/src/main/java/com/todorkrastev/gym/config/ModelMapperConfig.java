package com.todorkrastev.gym.config;

import com.todorkrastev.gym.model.dto.RegisterDTO;
import com.todorkrastev.gym.model.entity.User;
import org.hibernate.collection.spi.PersistentCollection;
import org.modelmapper.Condition;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


//TODO: Could be also configuration
@Component
public class ModelMapperConfig {

    private final PasswordEncoder passwordEncoder;

    public ModelMapperConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        /*
        mapper.getConfiguration().setPropertyCondition(new Condition<Object, Object>() {
            public boolean applies(MappingContext<Object, Object> context) {
                return !(context.getSource() instanceof PersistentCollection);
            }
        });
         */

        Converter<String, String> passwordHash = ctx -> ctx.getSource() == null ? null :
                passwordEncoder.encode(ctx.getSource());

        mapper.createTypeMap(RegisterDTO.class, User.class)
                .addMappings(mpr -> mpr.using(passwordHash)
                        .map(RegisterDTO::getPassword, User::setPassword));


        return mapper;
    }
}
