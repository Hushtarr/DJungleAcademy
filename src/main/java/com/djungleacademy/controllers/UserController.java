package com.djungleacademy.controllers;

import com.djungleacademy.dto.UserDTO;
import com.djungleacademy.dto.common.ApiInfo;
import com.djungleacademy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")

public class UserController {
    private final UserService userService;

    @GetMapping("/info")
    public ResponseEntity<ApiInfo<?>> getUserInfo() {

        if (userService.getLoggedInUser() != null) {
            // 返回用户信息
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ApiInfo.successReturn("User information retrieved successfully", userService.getLoggedInUser()));
        } else {
            // 若认证信息不存在或无效
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(ApiInfo.failure("Invalid or expired token"));
        }
    }

//    @GetMapping("/update")
//    public String showProfilePage() {
//
//    }

}
