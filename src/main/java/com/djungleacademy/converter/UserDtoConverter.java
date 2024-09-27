package com.djungleacademy.converter;

import com.djungleacademy.dto.UserDTO;
import com.djungleacademy.exceptions.UserNotFoundEx;
import com.djungleacademy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDtoConverter implements Converter<String, UserDTO> {
    private final UserService userService;


    @Override
    public UserDTO convert(String source) {
        if (source.trim().isEmpty()) {
            throw new UserNotFoundEx("User with ID " + source + " not found");
        }
        Long userId = Long.parseLong(source);
        UserDTO userDTO = userService.findById(userId);

        if (userDTO == null) {
            throw new UserNotFoundEx("User with ID " + source + " not found");
        }

        return userDTO;



    }

}
