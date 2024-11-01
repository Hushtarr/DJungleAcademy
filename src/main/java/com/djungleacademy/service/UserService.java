package com.djungleacademy.service;

import com.djungleacademy.dto.UserDTO;
import com.djungleacademy.enums.UserType;

import java.util.List;

public interface UserService {
    void save(UserDTO userDTO);
    UserDTO findByEmail(String userName);
    void update(UserDTO userDTO);
    List<UserDTO> findByRole(UserType userType);
    UserDTO findById(Long id);
    UserDTO getLoggedInUser();
}
