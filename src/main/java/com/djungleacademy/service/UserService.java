package com.djungleacademy.service;

import com.djungleacademy.dto.UserDTO;

public interface UserService {
    void save(UserDTO userDTO);
    UserDTO findByEmail(String userName);
    void update(UserDTO userDTO);
}
