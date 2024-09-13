package com.djungleacademy.service;

import com.djungleacademy.dto.UserDTO;
import com.djungleacademy.entity.User;

public interface UserService {
    void save(UserDTO userDTO);
}
