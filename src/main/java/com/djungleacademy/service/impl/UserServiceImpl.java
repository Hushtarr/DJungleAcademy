package com.djungleacademy.service.impl;

import com.djungleacademy.dto.UserDTO;
import com.djungleacademy.entity.User;
import com.djungleacademy.enums.UserType;
import com.djungleacademy.mapper.GlobalMapper;
import com.djungleacademy.repository.UserRepository;
import com.djungleacademy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final GlobalMapper globalMapper;

    @Override
    public void save(UserDTO userDTO) {
        User user=globalMapper.convert(userDTO, User.class);
//        user.setUserType(UserType.STUDENT);
        userRepository.save(user);
    }
}
