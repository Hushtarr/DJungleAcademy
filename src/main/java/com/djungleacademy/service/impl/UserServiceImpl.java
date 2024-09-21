package com.djungleacademy.service.impl;

import com.djungleacademy.dto.UserDTO;
import com.djungleacademy.entity.Address;
import com.djungleacademy.entity.User;
import com.djungleacademy.enums.UserType;
import com.djungleacademy.exceptions.UserNotFoundException;
import com.djungleacademy.mapper.GlobalMapper;
import com.djungleacademy.repository.UserRepository;
import com.djungleacademy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final GlobalMapper globalMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void save(UserDTO userDTO) {
        User user=globalMapper.convert(userDTO, User.class);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setUserType(UserType.STUDENT);
        userRepository.save(user);
    }

    public UserDTO findByEmail(String userName) {
        User user = userRepository.findByEmail(userName);
        return globalMapper.convert(user, UserDTO.class);
    }


    @Override
    public void update(UserDTO userDTO) {
        User user = userRepository.findByUserName(userDTO.getUserName()).orElseThrow(() -> new UserNotFoundException("User not found"));
        Address updatedAddress = globalMapper.convert(userDTO.getAddress(), Address.class);
        user.setAddress(updatedAddress);
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        userRepository.save(user);

    }
}
